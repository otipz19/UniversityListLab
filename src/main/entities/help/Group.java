package main.entities.help;

import main.exceptions.validation.InvalidGroupValueValidationException;

public class Group {
    private final int value;

    public Group(int value){
        validate(value);
        this.value = value;
    }

    private void validate(int value){
        if(value < 1 || value > 6){
            throw new InvalidGroupValueValidationException(value);
        }
    }

    public boolean equals(Group other){
        return other.value == value;
    }

    public String toString(){
        return Integer.toString(value);
    }
}
