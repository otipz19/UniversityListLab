package main.model.entities;

import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;

public interface IRepositoryEntity {

    default IMyList<Student> getStudents(){
        return getStudents(null);
    }

    default IMyList<Student> getStudents(StudentSearchFilter filter){
        return getStudents(filter, null);
    }

    IMyList<Student> getStudents(StudentSearchFilter filter, IComparator<Student> comparator);

    default IMyList<Teacher> getTeachers(){
        return getTeachers(null);
    }

    default IMyList<Teacher> getTeachers(TeacherSearchFilter filter){
        return getTeachers(filter, null);
    }

    IMyList<Teacher> getTeachers(TeacherSearchFilter filter, IComparator<Teacher> comparator);
}
