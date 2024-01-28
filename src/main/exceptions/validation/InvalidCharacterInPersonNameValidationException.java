package main.exceptions.validation;

public class InvalidCharacterInPersonNameValidationException extends ValidationException{
    public InvalidCharacterInPersonNameValidationException(String value){
        super("Person name must contain only letters. Provided value: " + value);
    }
}
