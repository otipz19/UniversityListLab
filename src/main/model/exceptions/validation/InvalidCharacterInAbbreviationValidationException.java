package main.model.exceptions.validation;

public class InvalidCharacterInAbbreviationValidationException extends ValidationException{
    public InvalidCharacterInAbbreviationValidationException(String value){
        super("Abbreviation must contain only letters. Provided value: " + value);
    }
}
