package main.entities;

import main.utils.list.StudentsList;
import main.utils.list.TeachersList;

public class Cathedra {
    private StudentsList students;
    private TeachersList teachers;

    public StudentsList getStudents() {
        return students;
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
