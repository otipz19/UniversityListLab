package main.model.utils.sorting.comparators;

import main.model.entities.Student;
import main.model.utils.sorting.IComparator;

public class ByCourseAscendingStudentComparator implements IComparator<Student> {
    @Override
    public int compare(Student left, Student right) {
        return left.getCourse().compareTo(right.getCourse());
    }
}
