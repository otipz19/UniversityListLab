package main.utils;

import main.entities.Student;

public class StudentsListImplementation extends MyListImplementation implements StudentsList{
    @Override
    public Student getAt(int i){
        return (Student) super.getAt(i);
    }

    @Override
    public void add(Student student) {
        super.add(student);
    }

    @Override
    public void insertAt(int i, Student student) {
        super.insertAt(i, student);
    }
}
