package main.model.utils.filtering;

import main.model.entities.Teacher;

public class TeacherSearchFilter extends SearchFilter<Teacher>{
    public TeacherSearchFilter(String searchTerm) {
        super(searchTerm);
    }

    @Override
    public boolean appliesTo(Teacher entity) {
        return PersonSearchFilter.applies(entity, searchTerm);
    }
}
