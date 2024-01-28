package main.exceptions.validation;

public class InvalidCourseValueValidationException extends ValidationException {
    public InvalidCourseValueValidationException(int value){
        super("Course value must be in range [1..4]. Provided value: " + value);
    }
}
