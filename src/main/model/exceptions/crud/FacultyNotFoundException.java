package main.model.exceptions.crud;

import main.model.entities.Faculty;

public class FacultyNotFoundException extends NotFoundException{
    public FacultyNotFoundException(Faculty faculty){
        super(faculty);
    }
}
