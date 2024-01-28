package main.utils.list;

import main.entities.Student;

public interface IStudentsList {
    void add(Student student);

    Student getAt(int i);

    void insertAt(int i, Student student);

    void removeAt(int i);

    void clear();

    int count();
}
