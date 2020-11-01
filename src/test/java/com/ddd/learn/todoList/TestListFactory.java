package com.ddd.learn.todoList;

import com.ddd.learn.todoList.List.model.entities.TodoList;

public class TestListFactory {

    public static TodoList getTestList(String listName){
        if ( listName.equals("default")){
            return _getDefaultTestList();
        }
        return new TodoList();
    }

    private static TodoList _getDefaultTestList(){
        TodoList returnList = new TodoList();
        returnList.setListId("12345");
        returnList.setName("Sample List");
        // TODO - add items if needed later
        return returnList;
    }
}
