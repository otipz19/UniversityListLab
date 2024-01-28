package main.entities.help;

import main.exceptions.validation.InvalidCharacterInAbbreviationValidationException;

public class OrganizationAbbreviation extends EntityName{
    public OrganizationAbbreviation(String value){
        super(value);
    }

    protected void validate(String value) {
        for(int i = 0; i < value.length(); i++){
            if(!Character.isLetter(value.charAt(i))){
                throw new InvalidCharacterInAbbreviationValidationException(value);
            }
        }
    }

    protected String normalize(String value){
        return value.toUpperCase();
    }
}
