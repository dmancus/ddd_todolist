package com.ddd.learn.todoList.List.application.entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationExceptionTest {
    @Test
    public void getUserFacingError(){
        ApplicationException ex = new ApplicationException("main app error", new Exception(), "some cause 1",
                "some cause 2");
        ArrayList<String> errors = ex.getUserFacingError();

        assertTrue(errors.size() == 3);
        assertTrue(errors.get(0).equals("main app error"));
        assertTrue(errors.get(1).equals("    some cause 1"));
        assertTrue(errors.get(2).equals("    some cause 2"));
    }
}
