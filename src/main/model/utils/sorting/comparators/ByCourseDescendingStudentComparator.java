package main.model.utils.sorting.comparators;

import main.model.entities.Student;
import main.model.utils.sorting.IComparator;

public class ByCourseDescendingStudentComparator implements IComparator<Student> {
    @Override
    public int compare(Student left, Student right) {
        return -1 * new ByGroupAscendingStudentComparator().compare(left, right);
    }
}
