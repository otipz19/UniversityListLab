package main.model.entities;

import main.model.exceptions.crud.StudentNotFoundException;
import main.model.exceptions.crud.TeacherNotFoundException;
import main.model.utils.Guard;
import main.model.utils.list.MyList;
import main.model.valueObjects.OrganizationName;
import main.model.utils.list.IMyList;

public class Cathedra {
    private OrganizationName name;

    private Faculty faculty;

    private final IMyList<Student> students = new MyList<Student>();
    private final IMyList<Teacher> teachers = new MyList<Teacher>();

    public Cathedra(OrganizationName name){
        Guard.againstNull(name);
        this.name = name;
    }

    /**
     * Adds student to students list and sets backwards link.
     */
    public void addStudent(Student student){
        //TODO: add student and set backward link
    }

    /**
     * Adds student to students list and sets backwards link.
     */
    public void addTeacher(Teacher teacher){
        //TODO: add teacher and set backward link
    }


    /**
     * Removes student from students list, if it presents in this list.
     * Otherwise, throws exception.
     * @throws StudentNotFoundException if student doesn't exist
     */
    public void removeStudent(Student student) throws StudentNotFoundException {
        //TODO: remove student, if exists
    }

    /**
     * Removes teacher from teachers list, if it presents in this list.
     * Otherwise, throws exception.
     * @throws TeacherNotFoundException if teacher doesn't exist
     */
    public void removeTeacher(Teacher teacher) throws TeacherNotFoundException {
        //TODO: remove teacher, if exists
    }

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
