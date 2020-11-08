package com.ddd.learn.todoList.List.infrastructure;

import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;

import java.io.IOException;
import java.util.List;

public interface ListDAO {
    public void createList(TodoList newList) throws IOException;
    public void addItemToList(String listId, Item newItem);
    public List<TodoList> getLists();
}
