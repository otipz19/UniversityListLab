package main.model.utils.sorting.comparators;

import main.model.entities.Faculty;
import main.model.utils.sorting.IComparator;

public class ByNameDescendingFacultyComparator implements IComparator<Faculty> {
    @Override
    public int compare(Faculty left, Faculty right) {
        return -1 * new ByNameAscendingFacultyComparator().compare(left, right);
    }
}
