package main.entities;

import main.utils.list.StudentsList;
import main.utils.list.TeachersList;

public class Cathedra {
    private OrganizationName name;

    private StudentsList students;
    private TeachersList teachers;

    public StudentsList getStudents() {
        return students;
    }

    public OrganizationName getName() {
        return name;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }

    public void setStudents(StudentsList students) {
        this.students = students;
    }

    public TeachersList getTeachers() {
        return teachers;
    }

    public void setTeachers(TeachersList teachers) {
        this.teachers = teachers;
    }
}
