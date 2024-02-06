package main.model.utils.filtering;

import main.model.entities.Cathedra;

public class CathedraSearchFilter extends SearchFilter<Cathedra> {
    public CathedraSearchFilter(String searchTerm) {
        super(searchTerm);
    }

    @Override
    public boolean appliesTo(Cathedra entity) {
        return entity.getName().contains(searchTerm);
    }
}
