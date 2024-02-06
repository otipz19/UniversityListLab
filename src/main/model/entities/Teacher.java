package main.model.entities;

import main.model.valueObjects.PersonName;

public class Teacher extends Person{
    public Teacher(PersonName firstName, PersonName middleName, PersonName lastName) {
        super(firstName, middleName, lastName);
    }
}
