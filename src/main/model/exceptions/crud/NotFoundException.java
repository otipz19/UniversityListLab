package main.model.exceptions.crud;

public abstract class NotFoundException extends CrudException{
    public NotFoundException(Object object){
        super("Entity: " + object + " was not found");
    }
}
