package main.model.utils.filtering;

import main.model.entities.Student;
import main.model.valueObjects.*;

public class StudentSearchFilter extends PersonSearchFilter {
    private Group groupToFilter;
    private Course courseToFilter;

    //Made package private intentionally.
    //Have to be constructed by builder.
    StudentSearchFilter(String searchTerm, Group groupToFilter, Course courseToFilter) {
        super(searchTerm);
        this.groupToFilter = groupToFilter;
        this.courseToFilter = courseToFilter;
    }

    public boolean appliesTo(Student student) {
        if (groupToFilter != null || courseToFilter != null) {
            boolean result = true;
            if (groupToFilter != null) {
                result &= student.getGroup().equals(groupToFilter);
            }
            if (courseToFilter != null) {
                result &= student.getCourse().equals(courseToFilter);
            }
            if (searchTerm != null) {
                result &= super.appliesTo(student);
            }
            return result;
        } else {
            return super.appliesTo(student)
                    || student.getCourse().toString().equals(searchTerm)
                    || student.getGroup().toString().equals(searchTerm);
        }
    }
}
