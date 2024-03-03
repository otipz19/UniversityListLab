package main.model.utils.sorting.comparators;

import main.model.entities.Person;
import main.model.utils.sorting.IComparator;

import java.text.Collator;
import java.util.Locale;

public class ByNameAscendingPersonComparator<T extends Person> implements IComparator<T> {
    @Override
    public int compare(T left, T right) {
        return NamesLocaleComparator.compare(getPib(left), getPib(right));
    }

    private String getPib(T person){
        return String.join(" ",
                person.getLastName().getValue(),
                person.getFirstName().getValue(),
                person.getMiddleName().getValue());
    }
}
