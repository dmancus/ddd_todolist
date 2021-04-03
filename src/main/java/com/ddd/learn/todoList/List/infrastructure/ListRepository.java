package com.ddd.learn.todoList.List.infrastructure;

import com.ddd.learn.todoList.List.UI.ListAPI;
import com.ddd.learn.todoList.List.infrastructure.JPA.ItemEntity;
import com.ddd.learn.todoList.List.infrastructure.JPA.TodoListEntity;
import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// Try to create a repository layer to serve as the intermediary
// between Application Layer and Infra layer
// Repository speaks the language of the domain but should be pretty
// thin.  DAOs will deal with infra implementations
@Component
public class ListRepository {

    @Autowired
    ListDAO listDAO;

    @Autowired
    ItemDAO itemDAO;

    Logger logger = LoggerFactory.getLogger(ListRepository.class);

    public void createList(TodoList newList) throws IOException{
        listDAO.save(convertTodoListToPhysicalModel(newList));
    }
    public void addItemToList (String listId, Item newItem) throws Exception{
        Optional<TodoListEntity> list = listDAO.findById(listId);
        if ( list.isPresent() ){
            itemDAO.save(convertNewItemToPhysicalModel(newItem, list.get()));
        }
        else{
            throw new Exception("TODO");
        }
    }
    public List<TodoList> getLists() {
         Iterable<TodoListEntity> listsFromDb = listDAO.findAll();
         ArrayList<TodoList> lists = new ArrayList<TodoList>();
         for ( TodoListEntity input : listsFromDb ){
             lists.add(convertTodoListFromPhysicalToModel(input));
         }
         return lists;
    }

    // Converters
    private TodoListEntity convertTodoListToPhysicalModel(TodoList newList){
        TodoListEntity result = new TodoListEntity();
        result.setList_id(newList.getListId());
        result.setName(newList.getName());
        return result;
    }

    private TodoList convertTodoListFromPhysicalToModel(TodoListEntity input){
        TodoList list = new TodoList();
        list.setListId(input.getList_id());
        list.setName(input.getName());
        list.setItems(new ArrayList<Item>());

        for ( ItemEntity itemEntity : input.getItems() ) {
            list.getItems().add(convertItemFromPhysicalToModel(itemEntity));
        }

        return list;
    }

    private ItemEntity convertNewItemToPhysicalModel(Item newItem, TodoListEntity listReference){
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItem_name(newItem.getItemName());
        itemEntity.setItem_desc(newItem.getItemDesc());
        itemEntity.setItem_id(newItem.getItemId());
        itemEntity.setItem_status(newItem.getItemStatus());
        itemEntity.setList_id(listReference.getList_id());
        return itemEntity;
    }

    private Item convertItemFromPhysicalToModel(ItemEntity itemEntity){
        Item item = new Item();
        item.setItemId(itemEntity.getItem_id());
        item.setItemName(itemEntity.getItem_name());
        item.setItemDesc(itemEntity.getItem_desc());
        item.setItemStatus(itemEntity.getItem_status());
        return item;
    }
}
