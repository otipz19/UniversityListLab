package main.model.exceptions.crud;

import main.model.exceptions.DomainException;

public abstract class CrudException extends DomainException {
    public CrudException(String msg){
        super(msg);
    }
}
