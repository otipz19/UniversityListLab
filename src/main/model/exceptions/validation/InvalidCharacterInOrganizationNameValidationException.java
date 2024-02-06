package main.model.exceptions.validation;

public class InvalidCharacterInOrganizationNameValidationException extends ValidationException{
    public InvalidCharacterInOrganizationNameValidationException(String value){
        super("Organization name must contain only letters and whitespace. Provided value: " + value);
    }
}
