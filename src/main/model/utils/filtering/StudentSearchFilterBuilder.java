package main.model.utils.filtering;

import main.model.valueObjects.*;

public class StudentSearchFilterBuilder {
    private String searchTerm;
    private Group group;
    private Course course;

    public StudentSearchFilterBuilder addSearchTerm(String searchTerm){
        this.searchTerm = searchTerm;
        return this;
    }

    public StudentSearchFilterBuilder addGroup(Group group){
        this.group = group;
        return this;
    }

    public StudentSearchFilterBuilder addCourse(Course course){
        this.course = course;
        return this;
    }

    public StudentSearchFilter build(){
        return new StudentSearchFilter(searchTerm, group, course);
    }
}
