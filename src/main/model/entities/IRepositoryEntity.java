package main.model.entities;

import main.model.utils.filtering.SearchFilter;
import main.model.utils.filtering.StudentSearchFilter;
import main.model.utils.filtering.TeacherSearchFilter;
import main.model.utils.list.IMyList;
import main.model.utils.sorting.IComparator;
/**
 * This interface is used to represent a repository entity.
 * It is a public interface because it is used in other packages.
 */
public interface IRepositoryEntity {

    default IMyList<Student> getStudents(){
        return getStudents(null, null);
    }

    default IMyList<Student> getStudents(SearchFilter<Student> filter){
        return getStudents(filter, null);
    }

    default IMyList<Student> getStudents(IComparator<Student> comparator){
        return getStudents(null, comparator);
    }

    IMyList<Student> getStudents(SearchFilter<Student> filter, IComparator<Student> comparator);

    default IMyList<Teacher> getTeachers(){
        return getTeachers(null, null);
    }

    default IMyList<Teacher> getTeachers(SearchFilter<Teacher> filter){
        return getTeachers(filter, null);
    }

    default IMyList<Teacher> getTeachers(IComparator<Teacher> comparator){
        return getTeachers(null, comparator);
    }

    IMyList<Teacher> getTeachers(SearchFilter<Teacher> filter, IComparator<Teacher> comparator);
}
