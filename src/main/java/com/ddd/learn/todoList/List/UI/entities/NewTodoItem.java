package com.ddd.learn.todoList.List.UI.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // For testing setup
public class NewTodoItem {
    @JsonProperty
    String itemName;

    @JsonProperty
    String itemDescription;
}
