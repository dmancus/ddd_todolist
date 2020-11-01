package com.ddd.learn.todoList.List.infrastructure;

import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;

import java.util.List;

public interface ListRepository {
    public void createList(TodoList newList);
    public void addItemToList(String listId, Item newItem);
    public List<TodoList> getLists();
}
