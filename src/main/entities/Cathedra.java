package main.entities;

import main.valueObjects.OrganizationName;
import main.utils.list.IMyList;

public class Cathedra {
    private OrganizationName name;

    private IMyList<Student> students;
    private IMyList<Teacher> teachers;

    public IMyList<Student> getStudents() {
        return students;
    }

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }

    public void setStudents(IMyList<Student> students) {
        this.students = students;
    }

    public IMyList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(IMyList<Teacher> teachers) {
        this.teachers = teachers;
    }
}
