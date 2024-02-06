package main.model.exceptions.crud;

public class NotFoundException extends CrudException{
    public NotFoundException(Object object){
        super("Entity: " + object + " was not found");
    }
}
