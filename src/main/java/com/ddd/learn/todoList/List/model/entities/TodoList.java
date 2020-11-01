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

    // TodoList should be able to tell us whether its complete
    // Empty list is NOT complete
    public boolean isComplete(){
        boolean status = true;
        if ( items == null || items.size() == 0 ){
            status = false;
        }
        else{
            for ( Item item : items ){
                if ( item.getItemStatus() != ItemStatus.DONE ){
                    status = false;
                    break;
                }
            }
        }
        return status;
    }
}
