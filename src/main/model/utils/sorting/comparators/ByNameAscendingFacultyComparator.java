package main.model.utils.sorting.comparators;

import main.model.entities.Faculty;
import main.model.utils.sorting.IComparator;

public class ByNameAscendingFacultyComparator implements IComparator<Faculty> {
    @Override
    public int compare(Faculty left, Faculty right) {
        return NamesLocaleComparator.compare(left.getName().getValue(), right.getName().getValue());
    }
}
