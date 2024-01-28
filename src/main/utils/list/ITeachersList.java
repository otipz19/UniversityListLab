package main.utils.list;

import main.entities.Teacher;

public interface ITeachersList {
    void add(Teacher teacher);

    Teacher getAt(int i);

    void insertAt(int i, Teacher teacher);

    void removeAt(int i);

    void clear();

    int count();
}
