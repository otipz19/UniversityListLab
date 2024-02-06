package main.model.entities;

import main.model.exceptions.crud.FacultyNotFoundException;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;

public class University {
    private final IMyList<Faculty> faculties = new MyList<Faculty>();

    /**
     * Adds new faculty to list of faculties.
     */
    public void addFaculty(Faculty faculty){
        //TODO: add faculty
    }

    /**
     * Removes faculty from list of faculties, if it presents in this list.
     * Otherwise, throws exception.
     * @throws FacultyNotFoundException if Faculty doesn't present in University
     */
    public void removeFaculty(Faculty faculty) throws FacultyNotFoundException {
        //TODO: remove faculty, if it presents
    }
}
