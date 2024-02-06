package tests.model.valueObjects;

import main.model.valueObjects.OrganizationName;
import main.model.exceptions.validation.InvalidCharacterInOrganizationNameValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationNameTest {
    @Test
    public void constructorThrowsExceptionOnDigitsInValue(){
        String value = "bla1";

        assertThrows(InvalidCharacterInOrganizationNameValidationException.class,
                () -> new OrganizationName(value));
    }

    @Test
    public void constructorNormalizedNameOnValidValue(){
        String value = "facULTY of INFORMATICS";

        OrganizationName name = new OrganizationName(value);

        assertEquals("Faculty Of Informatics", name.toString());
    }

    @Test
    public void equalsReturnsTrueByValue(){
        OrganizationName first = new OrganizationName("faculty");
        OrganizationName second = new OrganizationName("fACULty");

        assertTrue(first.equals(second));
    }
}