package main.model.entities;

import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;

public interface IRepositoryEntity {

    IMyList<Student> getStudents();

    IMyList<Student> getStudents(StudentSearchFilter filter);

    IMyList<Student> getStudents(StudentSearchFilter filter, IComparator<Student> comparator);

    IMyList<Teacher> getTeachers();

    IMyList<Teacher> getTeachers(TeacherSearchFilter filter);

    IMyList<Teacher> getTeachers(TeacherSearchFilter filter, IComparator<Teacher> comparator);
}
