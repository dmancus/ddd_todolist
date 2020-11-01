package com.ddd.learn.todoList.List.model.entities;

import com.ddd.learn.todoList.TestListFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {

    @Test
    public void isCompleteTest(){
        TodoList testList = TestListFactory.getTestList("default");

        // Empty list is not complete
        boolean test1 = testList.isComplete();
        assertFalse(test1);

        // Add items, still not complete
        Item item1 = new Item();
        item1.setItemName("item1");
        item1.setItemStatus(ItemStatus.CREATED);
        Item item2 = new Item();
        item2.setItemName("item2");
        item2.setItemStatus(ItemStatus.CREATED);
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(item1);
        itemList.add(item2);
        testList.setItems(itemList);

        boolean test2 = testList.isComplete();
        assertFalse(test2);

        // Mark one item done, still not complete
        item1.setItemStatus(ItemStatus.DONE);
        boolean test3 = testList.isComplete();
        assertFalse(test3);

        // All items done, then complete
        item2.setItemStatus(ItemStatus.DONE);
        boolean test4 = testList.isComplete();
        assertTrue(test4);
    }
}
