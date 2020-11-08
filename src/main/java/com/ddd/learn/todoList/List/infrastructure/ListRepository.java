package com.ddd.learn.todoList.List.infrastructure;

import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

// Try to create a repository layer to serve as the intermediary
// between Application Layer and Infra layer
// Repository speaks the language of the domain but should be pretty
// thin.  DAOs will deal with infra implementations
@Component
public class ListRepository {

    @Autowired
    ListDAO listDAO;

    public void createList(TodoList newList) throws IOException{
        listDAO.createList(newList);
    }
    public void addItemToList(String listId, Item newItem){
        listDAO.addItemToList(listId, newItem);
    }
    public List<TodoList> getLists() {
        return listDAO.getLists();
    }
}
