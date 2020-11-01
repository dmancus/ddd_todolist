package com.ddd.learn.todoList.List.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    public String itemId;
    public String itemName;
    public String itemDesc;
    public ItemStatus itemStatus;

}
