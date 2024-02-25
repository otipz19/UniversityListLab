package main.model.entities;

import main.model.entities.getters.StudentsGetter;
import main.model.entities.getters.TeachersGetter;
import main.model.exceptions.ObjectInListNotFoundException;
import main.model.exceptions.crud.*;
import main.model.utils.filtering.*;
import main.model.utils.list.*;

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

    /**
     * @return list of filtered faculties
     */
    public IMyList<Faculty> getFaculties(FacultySearchFilter filter) {
        var filteredFaculties = new MyList<Faculty>();
        for(int i = 0; i < faculties.count(); i++){
            Faculty cur = faculties.getAt(i);
            if(filter == null || filter.appliesTo(cur)){
                filteredFaculties.add(cur);
            }
        }
        return filteredFaculties;
    }

    //TODO: Sorting have to be implemented
    public IMyList<Student> getStudents(){
        return getStudents(null);
    }

    public IMyList<Student> getStudents(StudentSearchFilter filter){
        return StudentsGetter.getStudents(filter, faculties);
    }

    public IMyList<Teacher> getTeachers(){
        return getTeachers(null);
    }

    public IMyList<Teacher> getTeachers(TeacherSearchFilter filter){
        return TeachersGetter.getTeachers(filter, faculties);
    }
}
