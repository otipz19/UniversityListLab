package main.model.exceptions.crud;

import main.model.entities.Student;

public class StudentNotFoundException extends NotFoundException{
    public StudentNotFoundException(Student student){
        super(student);
    }
}
