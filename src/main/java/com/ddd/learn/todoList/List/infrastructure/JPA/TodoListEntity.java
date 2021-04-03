package com.ddd.learn.todoList.List.infrastructure.JPA;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="todo_lists")
@Data
public class TodoListEntity {
    @Id
    private String list_id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="list_id")
    List<ItemEntity> items;

}
