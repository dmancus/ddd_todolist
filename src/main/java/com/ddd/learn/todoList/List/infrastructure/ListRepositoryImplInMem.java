package com.ddd.learn.todoList.List.infrastructure;

import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Profile("!prod")
public class ListRepositoryImplInMem implements ListRepository {

    Map<String, TodoList> dataStore = new HashMap<String, TodoList>();

    public void createList(TodoList newList){
        dataStore.put(newList.getListId(), newList);
    }
    public void addItemToList(String listId, Item newItem){
        TodoList listToModify = dataStore.get(listId);
        // TODO - exception handling
        if ( listToModify.items == null ){
            listToModify.items = new ArrayList<Item>();
        }
        listToModify.items.add(newItem);
        dataStore.put(listId, listToModify);
    }

    public List<TodoList> getLists(){
        List<TodoList> returnList = new ArrayList<TodoList>();

        if (dataStore.isEmpty()){
            return returnList;
        }
        for ( String key : dataStore.keySet()){
            returnList.add(dataStore.get(key));
        }
        return returnList;
    }
}
