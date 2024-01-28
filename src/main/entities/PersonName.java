package main.entities;

import main.exceptions.validation.*;

public class PersonName {
    private String value;

    public PersonName(String value){
        validate(value);
        this.value = normalize(value);
    }

    public String toString(){
        return value;
    }

    public boolean equals(PersonName other){
        return value.toString().equals(other.toString());
    }

    private void validate(String value) {
        for(int i = 0; i < value.length(); i++){
            if(!Character.isLetter(value.charAt(i))){
                throw new InvalidCharacterInPersonNameValidationException(value);
            }
        }
    }

    private String normalize(String value){
        value = value.toLowerCase();
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
