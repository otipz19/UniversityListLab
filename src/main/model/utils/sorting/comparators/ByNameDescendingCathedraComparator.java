package main.model.utils.sorting.comparators;

import main.model.entities.Cathedra;
import main.model.utils.sorting.IComparator;

public class ByNameDescendingCathedraComparator implements IComparator<Cathedra> {
    @Override
    public int compare(Cathedra left, Cathedra right) {
        return -1 * new ByNameAscendingCathedraComparator().compare(left, right);
    }
}
