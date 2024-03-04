package main.model.entities;

import main.model.valueObjects.PersonName;
/*
 * This class is a concrete class that is used to represent a teacher.
 */
public class Teacher extends Person{
    /*
     * This method is used to create a teacher.
     * @param firstName - the first name of the teacher
     * @param middleName - the middle name of the teacher
     * @param lastName - the last name of the teacher
     * @return - the teacher
     */
    public Teacher(PersonName firstName, PersonName middleName, PersonName lastName) {
        super(firstName, middleName, lastName);
    }
}
