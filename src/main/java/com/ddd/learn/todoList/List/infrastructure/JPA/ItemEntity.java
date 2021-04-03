package com.ddd.learn.todoList.List.infrastructure.JPA;

import com.ddd.learn.todoList.List.model.entities.ItemStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="items")
@Data
public class ItemEntity {
    @Id
    private String item_id;
    private String list_id;
    private String item_name;
    private String item_desc;
    private ItemStatus item_status;

}

