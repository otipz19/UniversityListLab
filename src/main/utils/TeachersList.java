package main.utils;

import main.entities.Teacher;

public interface TeachersList {
    void add(Teacher teacher);

    Teacher getAt(int i);

    void insertAt(int i, Teacher teacher);

    void removeAt(int i);

    void clear();

    int count();
}
