package main.model.utils.sorting.comparators;

import main.model.entities.Person;
import main.model.utils.sorting.IComparator;

public class ByNameAscendingPersonComparator implements IComparator<Person> {
    @Override
    public int compare(Person left, Person right) {
        return getPib(left).compareTo(getPib(right));
    }

    private static String getPib(Person person){
        return String.join(" ",
                person.getLastName().getValue(),
                person.getFirstName().getValue(),
                person.getMiddleName().getValue());
    }
}
