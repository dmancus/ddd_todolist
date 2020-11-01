package com.ddd.learn.todoList.List.application;

import com.ddd.learn.todoList.List.UI.entities.NewTodoItem;
import com.ddd.learn.todoList.List.UI.entities.NewTodoList;
import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.ItemStatus;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import com.ddd.learn.todoList.TestListFactory;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListFactoryTest {
    //@Autowired
    //TestListFactory testListFactory;

    @Test
    public void createListFromUserInputTest(){
        NewTodoList testInput = new NewTodoList();
        testInput.setName("NewTestInput");

        ListFactory listFactory = new ListFactory();
        TodoList listToVerify = listFactory.createListFromUserInput(testInput);

        assertTrue(StringUtils.isNotBlank(listToVerify.getListId()));
        assertTrue(listToVerify.getName().equals("NewTestInput"));
        assertNull(listToVerify.getItems() );
    }

    @Test
    public void createItemFromUserInputTest(){
        NewTodoItem testInput = new NewTodoItem();
        testInput.setItemName("New Item");
        testInput.setItemDescription("Longer description with context of item");

        ListFactory listFactory = new ListFactory();
        Item itemToVerify = listFactory.createItemFromUserInput(testInput);

        assertTrue(itemToVerify.getItemDesc().equals("Longer description with context of item"));
        assertTrue(StringUtils.isNotBlank(itemToVerify.getItemId()));
        assertTrue(itemToVerify.getItemName().equals("New Item"));
        assertTrue(itemToVerify.getItemStatus().equals(ItemStatus.CREATED));
    }
}
