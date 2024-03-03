package main.initialization;

import main.model.entities.Teacher;
import main.model.valueObjects.PersonName;

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
