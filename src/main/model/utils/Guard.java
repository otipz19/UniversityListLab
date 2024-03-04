package main.model.utils;

import main.model.exceptions.NullArgumentException;
/**
 * This class is a concrete class that is used to represent a guard.
 * It is a public class because it is used in other packages.
 */
public class Guard {
    public static void againstNull(Object object){
        if(object == null){
            throw new NullArgumentException();
        }
    }
}
