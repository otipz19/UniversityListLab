package main.initialization;

import main.model.entities.Student;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.PersonName;

public class StudentsGenerator extends PersonGenerator<Student> {
    @Override
    protected Student generate() {
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
        Course course = new Course(rng.nextInt(1, 5));
        Group group = new Group(rng.nextInt(1, 7));
        return new Student(firstName, middleName, lastName, group, course);
    }
}
