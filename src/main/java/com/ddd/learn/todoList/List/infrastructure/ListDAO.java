package com.ddd.learn.todoList.List.infrastructure;

import com.ddd.learn.todoList.List.infrastructure.JPA.TodoListEntity;
import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.util.List;

// Key default methods:
// save(S entity)
// findById(id)
// findAll()
// deleteById(id)
//count
public interface ListDAO extends CrudRepository<TodoListEntity, String> {
}
