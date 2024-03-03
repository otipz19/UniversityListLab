package main.model.entities;

import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;

public interface IRepositoryEntity {

    default IMyList<Student> getStudents(){
        return getStudents(null, null);
    }

    default IMyList<Student> getStudents(StudentSearchFilter filter){
        return getStudents(filter, null);
    }

    default IMyList<Student> getStudents(IComparator<Student> comparator){
        return getStudents(null, comparator);
    }

    IMyList<Student> getStudents(StudentSearchFilter filter, IComparator<Student> comparator);

    default IMyList<Teacher> getTeachers(){
        return getTeachers(null, null);
    }

    default IMyList<Teacher> getTeachers(TeacherSearchFilter filter){
        return getTeachers(filter, null);
    }

    default IMyList<Teacher> getTeachers(IComparator<Teacher> comparator){
        return getTeachers(null, comparator);
    }

    IMyList<Teacher> getTeachers(TeacherSearchFilter filter, IComparator<Teacher> comparator);
}
