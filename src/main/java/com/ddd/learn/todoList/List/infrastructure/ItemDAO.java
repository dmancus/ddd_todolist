package com.ddd.learn.todoList.List.infrastructure;

import com.ddd.learn.todoList.List.infrastructure.JPA.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemDAO extends CrudRepository<ItemEntity, String> {
}
