package tests.model.valueObjects;

import main.model.valueObjects.Course;
import main.model.exceptions.validation.InvalidCourseValueValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    @Test
    public void constructorThrowsExceptionOnInvalidValue(){
        int value = 5;

        assertThrows(InvalidCourseValueValidationException.class, () -> new Course(value));
    }

    @Test
    public void constructorDoesNotThrowExceptionOnValidValue(){
        int rightBorder = 4;
        int leftBorder = 1;

        assertDoesNotThrow(() -> new Course(rightBorder));
        assertDoesNotThrow(() -> new Course(leftBorder));
    }

    @Test
    public void equalsReturnsTrueByValue(){
        int value = 1;
        Course first = new Course(value);
        Course second = new Course(value);

        assertTrue(first.equals(second));
    }
}