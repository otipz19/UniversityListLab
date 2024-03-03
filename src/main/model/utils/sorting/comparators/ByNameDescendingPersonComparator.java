package main.model.utils.sorting.comparators;

import main.model.entities.Person;
import main.model.utils.sorting.IComparator;

public class ByNameDescendingPersonComparator<T extends Person> implements IComparator<T> {
    @Override
    public int compare(T left, T right) {
        return -1 * new ByNameAscendingPersonComparator<T>().compare(left, right);
    }
}
