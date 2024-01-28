package main.utils;

import main.entities.Teacher;

public class TeachersListImplementation extends MyListImplementation implements TeachersList{
    @Override
    public Teacher getAt(int i){
        return (Teacher) super.getAt(i);
    }

    @Override
    public void add(Teacher teacher) {
        super.add(teacher);
    }

    @Override
    public void insertAt(int i, Teacher teacher) {
        super.insertAt(i, teacher);
    }
}
