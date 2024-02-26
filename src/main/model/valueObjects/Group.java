package main.model.valueObjects;

import main.model.exceptions.validation.InvalidGroupValueValidationException;

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

    public int compareTo(Group other){
        return Integer.compare(this.value, other.value);
    }

    public int getValue(){
        return value;
    }
}
