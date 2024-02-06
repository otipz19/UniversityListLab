package main.model.valueObjects;

import main.model.exceptions.validation.*;

public class PersonName extends EntityName{
    public PersonName(String value){
        super(value);
    }

    protected void validate(String value) {
        for(int i = 0; i < value.length(); i++){
            if(!Character.isLetter(value.charAt(i))){
                throw new InvalidCharacterInPersonNameValidationException(value);
            }
        }
    }

    protected String normalize(String value){
        value = value.toLowerCase();
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
