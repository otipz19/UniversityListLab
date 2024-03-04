package tests.model.valueObjects;

import main.model.valueObjects.OrganizationAbbreviation;
import main.model.exceptions.validation.InvalidCharacterInAbbreviationValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class is used to represent an organization abbreviation test.
 */
class OrganizationAbbreviationTest {
    @Test
    public void constructorThrowsExceptionOnDigitsInValue(){
        String value = "bla1";

        assertThrows(InvalidCharacterInAbbreviationValidationException.class,
                () -> new OrganizationAbbreviation(value));
    }

    @Test
    public void constructorNormalizedNameOnValidValue(){
        String value = "fIn";

        OrganizationAbbreviation name = new OrganizationAbbreviation(value);

        assertEquals("FIN", name.toString());
    }

    @Test
    public void equalsReturnsTrueByValue(){
        OrganizationAbbreviation first = new OrganizationAbbreviation("fin");
        OrganizationAbbreviation second = new OrganizationAbbreviation("fIN");

        assertTrue(first.equals(second));
    }
}