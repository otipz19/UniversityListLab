package main.model.utils.filtering;

import main.model.entities.Student;

public class StudentSearchFilter extends PersonSearchFilter{
    public StudentSearchFilter(String searchTerm) {
        super(searchTerm);
    }

    public boolean appliesTo(Student student){
        return super.appliesTo(student)
                || student.getCourse().toString().equals(searchTerm)
                || student.getGroup().toString().equals(searchTerm);
    }
}
