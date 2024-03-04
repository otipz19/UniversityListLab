package main.ui.readers;

import DataInputUtil.main.ConsoleDataReader;
import main.model.exceptions.validation.ValidationException;
import main.model.valueObjects.*;
/**
 * This class is used to represent a value object reader.
 * It is a public class because it is used in other packages.
 */
public class ValueObjectReader {
    public static OrganizationName readOrganizationName(String prompt) {
        return readValueObject(prompt, OrganizationName::new, ConsoleDataReader::getLine);
    }

    public static OrganizationAbbreviation readOrganizationAbbreviation(String prompt) {
        return readValueObject(prompt, OrganizationAbbreviation::new, ConsoleDataReader::getLine);
    }

    public static PersonName readPersonName(String prompt){
        return readValueObject(prompt, PersonName::new, ConsoleDataReader::getLine);
    }

    public static Course readCourse(String prompt){
        return readValueObject(prompt, Course::new, ConsoleDataReader::getInt);
    }

    public static Group readGroup(String prompt){
        return readValueObject(prompt, Group::new, ConsoleDataReader::getInt);
    }

    private static <TReturn, TParam> TReturn readValueObject(
            String prompt,
            ValueObjectCtor<TReturn, TParam> ctor,
            ConsoleReader<TParam> reader){
        while (true) {
            TParam value = reader.read(prompt);
            try {
                return ctor.ctor(value);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private interface ValueObjectCtor<TReturn, TParam>{
        TReturn ctor(TParam param);
    }

    private interface ConsoleReader<T>{
        T read(String prompt);
    }
}
