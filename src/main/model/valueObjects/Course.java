package main.model.valueObjects;

import main.model.exceptions.validation.InvalidCourseValueValidationException;

public class Course {
    private final int value;

    public Course(int value){
        validate(value);
        this.value = value;
    }

    private void validate(int value){
        if(value < 1 || value > 4){
            throw new InvalidCourseValueValidationException(value);
        }
    }

    public double getValue(){
        return value;
    }

    public boolean equals(Course other){
        return other.value == value;
    }

    public String toString(){
        return Integer.toString(value);
    }

    public int compareTo(Course other){
        return Integer.compare(this.value, other.value);
    }
}
