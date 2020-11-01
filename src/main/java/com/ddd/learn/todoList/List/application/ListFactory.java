package com.ddd.learn.todoList.List.application;

import com.ddd.learn.todoList.List.UI.entities.NewTodoItem;
import com.ddd.learn.todoList.List.UI.entities.NewTodoList;
import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.ItemStatus;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ListFactory {
    public TodoList createListFromUserInput(NewTodoList listInput){
        TodoList returnList = new TodoList();
        returnList.setName(listInput.getName());
        returnList.setListId(getGuid());

        return returnList;
    }

    public Item createItemFromUserInput(NewTodoItem itemInput){
        Item returnItem = new Item();
        returnItem.setItemName(itemInput.getItemName());
        returnItem.setItemDesc(itemInput.getItemDescription());
        returnItem.setItemStatus(ItemStatus.CREATED);
        returnItem.setItemId(getGuid());
        return returnItem;
    }

    private String getGuid(){
        return UUID.randomUUID().toString();
    }
}
