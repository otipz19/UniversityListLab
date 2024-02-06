package main.model.exceptions.validation;

public class ValidationException extends RuntimeException{
    public ValidationException(String msg){
        super(msg);
    }
}
