package com.ddd.learn.todoList.List.application.entities;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Getter
@Setter
public class ApplicationException extends Exception {

    private String mainMessage;
    private String[] detailMessages = new String[0];

    public ApplicationException(String mainError, Throwable aCause, String... aDetailMessages){
        super (mainError, aCause);
        this.mainMessage = mainError;
        this.detailMessages = ( (aDetailMessages==null) ? (new String[0]) : aDetailMessages );
    }

    public ArrayList<String> getUserFacingError(){
        ArrayList<String> errors = new ArrayList<String>();
        errors.add(this.mainMessage);
        if ( detailMessages.length > 0 ){
            for ( String s : detailMessages ){
                errors.add("    " + s);
            }
        }
        return errors;
    }

}
