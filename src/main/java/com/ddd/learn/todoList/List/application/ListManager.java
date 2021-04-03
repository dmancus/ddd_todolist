package com.ddd.learn.todoList.List.application;

import com.ddd.learn.todoList.List.UI.entities.NewTodoItem;
import com.ddd.learn.todoList.List.UI.entities.NewTodoList;
import com.ddd.learn.todoList.List.application.entities.ApplicationException;
import com.ddd.learn.todoList.List.infrastructure.ListRepository;
import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ListManager {

    @Autowired
    ListRepository listRepository;

    @Autowired
    ListFactory listFactory;

    public TodoList createList(NewTodoList newListInput) throws ApplicationException{
        TodoList newList = listFactory.createListFromUserInput(newListInput);
        // Java best practice - throw early, catch late
        // So infra level can throw error, then let it pass up to
        // application layer before catching
        try {
            listRepository.createList(newList);
        }
        catch(IOException e){
            throw new ApplicationException("Encountered problem when trying to create new list: " + newList.getName(), e, e.getMessage());
        }
        return newList;
    }

    public Item addItem(String listId, NewTodoItem newItemInput){
        // DDD design question...should an Item be a root aggregate, or only a child of Lists?
        // Our domain is TODO Lists, so that should be our bounded context.  But that means
        // we should never directly be creating or manipulating items, but only do so via lists,
        // which would break down.  For now, just treat them as two aggregates and move forward in
        // a simple way
        Item newItem = listFactory.createItemFromUserInput(newItemInput);
        try {
            listRepository.addItemToList(listId, newItem);
        }
        catch( Exception e){
            // TODO
        }
        return newItem;
    }

    public List<TodoList> getLists(){
        return listRepository.getLists();
    }
}
