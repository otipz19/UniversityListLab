package main.model.entities;

import main.model.utils.Guard;
import main.model.valueObjects.PersonName;
/*
 * This class is a concrete class that is used to represent a person.
 * It is a concrete class because it is meant to be instantiated.
 * It is a public class because it is used in other packages.
 */
public class Person {
    private PersonName firstName;
    private PersonName middleName;
    private PersonName lastName;

    private Cathedra cathedra;

    public Person(PersonName firstName, PersonName middleName, PersonName lastName){
        Guard.againstNull(firstName);
        Guard.againstNull(middleName);
        Guard.againstNull(lastName);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public PersonName getFirstName() {
        return firstName;
    }

    public void setFirstName(PersonName firstName) {
        Guard.againstNull(firstName);
        this.firstName = firstName;
    }

    public PersonName getMiddleName() {
        return middleName;
    }

    public void setMiddleName(PersonName middleName) {
        Guard.againstNull(middleName);
        this.middleName = middleName;
    }

    public PersonName getLastName() {
        return lastName;
    }

    public void setLastName(PersonName lastName) {
        Guard.againstNull(lastName);
        this.lastName = lastName;
    }

    public Cathedra getCathedra() {
        return cathedra;
    }

    public void setCathedra(Cathedra cathedra) {
        Guard.againstNull(cathedra);
        this.cathedra = cathedra;
    }

    @Override
    public String toString(){
        return "Name: " + lastName + " " + firstName + " " + middleName;
    }
}
