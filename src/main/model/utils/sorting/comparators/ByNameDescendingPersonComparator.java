package main.model.utils.sorting.comparators;

import main.model.entities.Person;
import main.model.utils.sorting.IComparator;

public class ByNameDescendingPersonComparator implements IComparator<Person> {
    @Override
    public int compare(Person left, Person right) {
        return -1 * new ByNameAscendingPersonComparator().compare(left, right);
    }
}
