package main.model.utils.sorting.comparators;

import main.model.entities.Cathedra;
import main.model.utils.sorting.IComparator;

public class ByNameAscendingCathedraComparator implements IComparator<Cathedra> {
    @Override
    public int compare(Cathedra left, Cathedra right) {
        return left.getName().compareTo(right.getName());
    }
}
