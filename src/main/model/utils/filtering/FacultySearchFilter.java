package main.model.utils.filtering;

import main.model.entities.Faculty;

public class FacultySearchFilter extends SearchFilter<Faculty> {
    public FacultySearchFilter(String searchTerm) {
        super(searchTerm);
    }

    @Override
    public boolean appliesTo(Faculty entity) {
        return entity.getName().contains(searchTerm) || entity.getAbbreviation().contains(searchTerm);
    }
}
