package com.ddd.learn.todoList.List.application;

import com.ddd.learn.todoList.List.UI.entities.NewTodoItem;
import com.ddd.learn.todoList.List.UI.entities.NewTodoList;
import com.ddd.learn.todoList.List.infrastructure.ListRepository;
import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListManager {

    @Autowired
    ListRepository listRepository;

    @Autowired
    ListFactory listFactory;

    public TodoList createList(NewTodoList newListInput){
        TodoList newList = listFactory.createListFromUserInput(newListInput);
        // may need to validate or enhance, but for now nothing to do
        listRepository.createList(newList);
        return newList;
    }

    public Item addItem(String listId, NewTodoItem newItemInput){
        // DDD design question...should an Item be a root aggregate, or only a child of Lists?
        // Our domain is TODO Lists, so that should be our bounded context.  But that means
        // we should never directly be creating or manipulating items, but only do so via lists,
        // which would break down.  For now, just treat them as two aggregates and move forward in
        // a simple way
        Item newItem = listFactory.createItemFromUserInput(newItemInput);
        listRepository.addItemToList(listId, newItem);
        return newItem;
    }

    public List<TodoList> getLists(){
        return listRepository.getLists();
    }
}
