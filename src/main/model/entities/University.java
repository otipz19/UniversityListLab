package main.model.entities;

import main.model.entities.getters.EntitiesGetter;
import main.model.entities.getters.StudentsGetter;
import main.model.entities.getters.TeachersGetter;
import main.model.exceptions.ObjectInListNotFoundException;
import main.model.exceptions.crud.*;
import main.model.utils.filtering.*;
import main.model.utils.list.*;
import main.model.utils.sorting.IComparator;

public class University implements IRepositoryEntity{
    private final IMyList<Faculty> faculties = new MyList<Faculty>();

    /**
     * Adds new faculty to list of faculties.
     */
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
        faculty.setUniversity(this);
    }

    /**
     * Removes faculty from list of faculties, if it presents in this list.
     * Otherwise, throws exception.
     *
     * @throws FacultyNotFoundException if Faculty doesn't present in University
     */
    public void removeFaculty(Faculty faculty) throws FacultyNotFoundException {
        try {
            faculties.remove(faculty);
        } catch (ObjectInListNotFoundException ex) {
            throw new FacultyNotFoundException(faculty);
        }
    }

    /**
     * @return list of all faculties
     */
    public IMyList<Faculty> getFaculties() {
        return getFaculties(null);
    }

    public IMyList<Faculty> getFaculties(FacultySearchFilter filter){
        return getFaculties(filter, null);
    }

    /**
     * @return list of filtered faculties
     */
    public IMyList<Faculty> getFaculties(FacultySearchFilter filter, IComparator<Faculty> comparator) {
        return EntitiesGetter.getEntities(faculties, filter, comparator);
    }

    public IMyList<Student> getStudents(StudentSearchFilter filter, IComparator<Student> comparator){
        return StudentsGetter.getStudents(faculties, filter, comparator);
    }

    public IMyList<Teacher> getTeachers(TeacherSearchFilter filter, IComparator<Teacher> comparator){
        return TeachersGetter.getTeachers(faculties, filter, comparator);
    }
}
