package main.exceptions.validation;

public class InvalidCharacterInPersonNameValidationException extends ValidationException{
    public InvalidCharacterInPersonNameValidationException(String value){
        super("Invalid character in person name: " + value);
    }
}
