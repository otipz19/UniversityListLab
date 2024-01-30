package tests.valueObjects;

import main.valueObjects.Group;
import main.exceptions.validation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    @Test
    public void constructorThrowsExceptionOnInvalidValue(){
        int value = 69;

        assertThrows(InvalidGroupValueValidationException.class, () -> new Group(value));
    }

    @Test
    public void constructorDoesNotThrowExceptionOnValidValue(){
        int rightBorder = 6;
        int leftBorder = 1;

        assertDoesNotThrow(() -> new Group(rightBorder));
        assertDoesNotThrow(() -> new Group(leftBorder));
    }

    @Test
    public void equalsReturnsTrueByValue(){
        int value = 1;
        Group first = new Group(value);
        Group second = new Group(value);

        assertTrue(first.equals(second));
    }
}