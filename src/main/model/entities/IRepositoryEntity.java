package main.model.entities;

import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;

public interface IRepositoryEntity {

    IMyList<Student> getStudents();

    IMyList<Student> getStudents(StudentSearchFilter filter);

    IMyList<Teacher> getTeachers();

    IMyList<Teacher> getTeachers(TeacherSearchFilter filter);
}
