package main.exceptions.validation;

public class InvalidGroupValueValidationException extends ValidationException {
    public InvalidGroupValueValidationException(int value){
        super("Group value must be in range [1..6]. Provided value: " + value);
    }
}
