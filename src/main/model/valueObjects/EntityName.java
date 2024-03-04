package main.model.valueObjects;

import main.model.exceptions.validation.InvalidCharacterInOrganizationNameValidationException;
import main.model.utils.Guard;

public abstract class EntityName {
    protected final String value;

    public EntityName(String value) {
        Guard.againstNull(value);
        if(value.isBlank()){
            throw new InvalidCharacterInOrganizationNameValidationException(value);
        }
        value = value.trim();
        validate(value);
        this.value = normalize(value);
    }

    protected abstract void validate(String value);

    protected abstract String normalize(String value);

    public String getValue(){
        return value;
    }

    public String toString() {
        return value;
    }

    public boolean equals(Object other) {
        if(!other.getClass().equals(this.getClass())){
            return false;
        }
        return value.toString().equals(other.toString());
    }

    public boolean contains(String term){
        return value.toLowerCase().contains(term);
    }

    public int compareTo(EntityName other){
        return this.getValue().compareTo(other.getValue());
    }
}
