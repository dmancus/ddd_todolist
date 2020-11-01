package com.ddd.learn.todoList.List.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// RootAggregate
@Getter
@Setter
public class TodoList {
    public String listId;
    public String name;
    public List<Item> items;

}
