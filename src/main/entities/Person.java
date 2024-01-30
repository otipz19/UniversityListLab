package main.entities;

import main.valueObjects.PersonName;

public class Person {
    private PersonName firstName;
    private PersonName middleName;
    private PersonName lastName;

    private Cathedra cathedra;

    public PersonName getFirstName() {
        return firstName;
    }

    public void setFirstName(PersonName firstName) {
        this.firstName = firstName;
    }

    public PersonName getMiddleName() {
        return middleName;
    }

    public void setMiddleName(PersonName middleName) {
        this.middleName = middleName;
    }

    public PersonName getLastName() {
        return lastName;
    }

    public void setLastName(PersonName lastName) {
        this.lastName = lastName;
    }

    public Cathedra getCathedra() {
        return cathedra;
    }

    public void setCathedra(Cathedra cathedra) {
        this.cathedra = cathedra;
    }
}
