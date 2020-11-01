package com.ddd.learn.todoList.List.UI;

import com.ddd.learn.todoList.List.UI.entities.GetListResponse;
import com.ddd.learn.todoList.List.UI.entities.NewTodoItem;
import com.ddd.learn.todoList.List.UI.entities.NewTodoList;
import com.ddd.learn.todoList.List.application.ListManager;
import com.ddd.learn.todoList.List.model.entities.Item;
import com.ddd.learn.todoList.List.model.entities.TodoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListAPI {

    @Autowired
    ListManager listManager;

    Logger logger = LoggerFactory.getLogger(ListAPI.class);

    @RequestMapping("/test")
    public String test (){
        return "Hello world!";
    }

    @GetMapping("/todo_lists")
    public List<TodoList> getLists(){
        logger.debug("call to /todo_lists");
        return listManager.getLists();
    }

    @PostMapping("/todo_list")
    public TodoList createList(@RequestBody NewTodoList newList){
        logger.debug("call to POST /todo_list");
        return listManager.createList(newList);
    }

    @PostMapping("/todo_list/{listId}/item")
    public Item addItemToList(@PathVariable String listId, @RequestBody NewTodoItem newItem){
        logger.debug("call to /todo_list/{}/item", listId);
        return listManager.addItem(listId, newItem);
    }

    @GetMapping("/todo_list/{listId}")
    public GetListResponse getList(@PathVariable String listId) {
        logger.debug("call to /todo_list/{}", listId);
        GetListResponse response = new GetListResponse();
        try {
            throw new Exception("Test exception!");
        }
        catch(Exception e){
            response.setErrors(new ArrayList<String>());
            response.getErrors().add(e.getMessage());
        }
        return response;
    }

    @PutMapping("/todo_list/list/{listId}/item/{itemId}/complete")
    public void completeItem(@PathVariable String listId, @PathVariable String itemId){

    }
}
