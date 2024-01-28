package tests.entities;

import main.entities.OrganizationAbbreviation;
import main.entities.OrganizationName;
import main.exceptions.validation.InvalidCharacterInAbbreviationValidationException;
import main.exceptions.validation.InvalidCharacterInOrganizationNameValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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