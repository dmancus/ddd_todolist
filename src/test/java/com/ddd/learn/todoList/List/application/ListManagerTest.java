package com.ddd.learn.todoList.List.application;

import com.ddd.learn.todoList.List.UI.entities.NewTodoItem;
import com.ddd.learn.todoList.List.UI.entities.NewTodoList;
import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import com.ddd.learn.todoList.TodoListApplication;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ListManagerTest {

    @Autowired
    ListManager listManager;

    @Test
    public void createListTest (){
        // Prepare sample input
        NewTodoList testInput = new NewTodoList();
        testInput.setName("test list");

        // call listManager.create
        TodoList testList = listManager.createList(testInput);

        // check results
        assertTrue(StringUtils.isNotBlank(testList.getListId()));
        assertTrue(testList.getName().equals("test list"));
    }

    @Test
    public void createItemTest (){
        // Prepare sample list
        NewTodoList setupInput = new NewTodoList();
        setupInput.setName("test list");
        TodoList testList = listManager.createList(setupInput);

        // New input item on our list
        NewTodoItem testInput = new NewTodoItem();
        testInput.setItemName("test item");
        testInput.setItemDescription("test description");

        // call listManager.create
        Item testItem = listManager.addItem(testList.getListId(), testInput);

        // check results
        assertTrue(StringUtils.isNotBlank(testItem.getItemId()));
        assertTrue(testList.getItems().size() == 1);
        assertTrue(testItem.getItemDesc().equals("test description"));
        assertTrue(testItem.getItemName().equals("test item"));
    }
}
