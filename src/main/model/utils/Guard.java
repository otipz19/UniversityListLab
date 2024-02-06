package main.model.utils;

import main.model.exceptions.NullArgumentException;

public class Guard {
    public static void againstNull(Object object){
        if(object == null){
            throw new NullArgumentException();
        }
    }
}
