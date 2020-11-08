package com.ddd.learn.todoList.List.UI.entities;

import com.ddd.learn.todoList.List.model.entities.TodoList;
import lombok.Generated;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Generated
public class CreateListResponse {
    public TodoList list;
    public boolean success;
    public ArrayList<String> errors;
}
