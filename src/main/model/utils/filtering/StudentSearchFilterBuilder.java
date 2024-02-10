package main.model.utils.filtering;

import main.model.valueObjects.*;

public class StudentSearchFilterBuilder {
    private String searchTerm;
    private Group group;
    private Course course;

    public void addSearchTerm(String searchTerm){
        this.searchTerm = searchTerm;
    }

    public void addGroup(Group group){
        this.group = group;
    }

    public void addCourse(Course course){
        this.course = course;
    }

    public StudentSearchFilter build(){
        return new StudentSearchFilter(searchTerm, group, course);
    }
}
