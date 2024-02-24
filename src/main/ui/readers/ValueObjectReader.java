package main.ui.readers;

import DataInputUtil.main.ConsoleDataReader;
import main.model.exceptions.validation.ValidationException;
import main.model.valueObjects.*;

public class ValueObjectReader {
    public static OrganizationName readOrganizationName(String prompt) {
        return readStringValueObject(prompt, OrganizationName::new);
    }

    public static OrganizationAbbreviation readOrganizationAbbreviation(String prompt) {
        return readStringValueObject(prompt, OrganizationAbbreviation::new);
    }

    public static PersonName readPersonName(String prompt){
        return readStringValueObject(prompt, PersonName::new);
    }

    public static Course readCourse(String prompt){
        return readIntValueObject(prompt, Course::new);
    }

    public static Group readGroup(String prompt){
        return readIntValueObject(prompt, Group::new);
    }

    private static <T> T readStringValueObject(
            String prompt,
            StringValueObjectCtor<T> ctor){
        while (true) {
            String value = ConsoleDataReader.getLine(prompt);
            try {
                return ctor.ctor(value);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static <T> T readIntValueObject(
            String prompt,
            IntValueObjectCtor<T> ctor){
        while (true) {
            int value = ConsoleDataReader.getInt(prompt);
            try {
                return ctor.ctor(value);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private interface StringValueObjectCtor<T>{
        T ctor(String param);
    }

    private interface IntValueObjectCtor<T>{
        T ctor(int param);
    }
}
