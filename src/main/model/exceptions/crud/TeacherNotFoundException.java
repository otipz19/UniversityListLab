package main.model.exceptions.crud;

import main.model.entities.Teacher;

public class TeacherNotFoundException extends NotFoundException{
    public TeacherNotFoundException(Teacher teacher){
        super(teacher);
    }
}
