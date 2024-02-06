package tests.model.valueObjects;

import main.model.valueObjects.PersonName;
import main.model.exceptions.validation.InvalidCharacterInPersonNameValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonNameTest {
    @Test
    public void constructorThrowsExceptionOnDigitsInValue(){
        String value = "bla1";

        assertThrows(InvalidCharacterInPersonNameValidationException.class, () -> new PersonName(value));
    }

    @Test
    public void constructorNormalizedNameOnValidValue(){
        String value = "alex";

        PersonName name = new PersonName(value);

        assertEquals("Alex", name.toString());
    }

    @Test
    public void equalsReturnsTrueByValue(){
        PersonName first = new PersonName("alex");
        PersonName second = new PersonName("ALEx");

        assertTrue(first.equals(second));
    }
}