package main.model.exceptions;

public abstract class DomainException extends RuntimeException{
    public DomainException(String msg){
        super(msg);
    }
}
