package main.initialization;

import main.model.entities.Teacher;
import main.model.valueObjects.PersonName;
/*
 * This class is a concrete class that is used to generate a list of teachers.
 * It is a concrete class because it is meant to be instantiated.
 * It is a public class because it is used in other packages.
 */
public class TeachersGenerator extends PersonGenerator<Teacher>{
    @Override
    protected Teacher generate() {
        PersonName firstName, middleName, lastName;
        boolean isFemale = rng.nextBoolean();
        if (isFemale) {
            firstName = getRandomName(femaleFirstNames);
            middleName = getRandomName(femaleMiddleNames);
            lastName = getRandomName(femaleLastNames);
        } else {
            firstName = getRandomName(maleFirstNames);
            middleName = getRandomName(maleMiddleNames);
            lastName = getRandomName(maleLastNames);
        }
        return new Teacher(firstName, middleName, lastName);
    }
}
