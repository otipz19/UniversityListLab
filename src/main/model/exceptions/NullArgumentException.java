package main.model.exceptions;

public class NullArgumentException extends DomainException{
    public NullArgumentException(){
        super("Tried to assign null to entity field");
    }
}
