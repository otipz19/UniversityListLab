package main.initialization;

import main.model.entities.Student;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.PersonName;
/*
 * This class is a concrete class that is used to generate a list of students.
 * It is a concrete class because it is meant to be instantiated.
 * It is a public class because it is used in other packages.
 */
public class StudentsGenerator extends PersonGenerator<Student> {
    /*
     * This method is used to generate a student.
     * It is a protected method because it is only used in this class and its subclasses.
     * It is a final method because it should not be overridden.
     */
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
        /*
         * This method is used to generate a random course and group for a student.
         * It is a final method because it should not be overridden.
         */
        Course course = new Course(rng.nextInt(1, 5));
        Group group = new Group(rng.nextInt(1, 7));
        return new Student(firstName, middleName, lastName, group, course);
    }
}
