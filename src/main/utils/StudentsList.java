package main.utils;

import main.entities.Student;
import main.entities.Teacher;

public interface StudentsList {
    void add(Student student);

    Student getAt(int i);

    void insertAt(int i, Student student);

    void removeAt(int i);

    void clear();

    int count();
}
