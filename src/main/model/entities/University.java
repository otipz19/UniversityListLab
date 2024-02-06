package main.model.entities;

import main.model.exceptions.crud.*;
import main.model.utils.filtering.*;
import main.model.utils.list.*;

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

    /**
     * @return list of all faculties
     */
    public IMyList<Faculty> getFaculties(){
        //TODO: return copy of faculties list, so original list can't be changed by ui
        return null;
    }

    /**
     * @return list of filtered faculties
     */
    public IMyList<Faculty> getFaculties(FacultySearchFilter filter){
        //TODO: return filtered faculties list. If no faculties applies to filter, return empty list.
        return null;
    }
}
