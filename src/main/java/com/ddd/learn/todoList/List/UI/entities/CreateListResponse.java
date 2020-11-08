package com.ddd.learn.todoList.List.UI.entities;

import com.ddd.learn.todoList.List.model.entities.TodoList;
import lombok.Setter;

import java.util.ArrayList;

@Setter
public class CreateListResponse {
    public TodoList list;
    public boolean success;
    public ArrayList<String> errors;
}
