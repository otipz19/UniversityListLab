package main.model.exceptions;

public class ObjectInListNotFoundException extends RuntimeException{
    public ObjectInListNotFoundException(Object object){
        super("Not found " + object + " in list");
    }
}
