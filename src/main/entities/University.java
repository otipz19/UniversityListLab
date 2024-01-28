package main.entities;

import main.utils.list.FacultiesList;

public class University {
    private FacultiesList faculties;

    public void setFaculties(FacultiesList faculties){
        this.faculties = faculties;
    }

    public FacultiesList getFaculties(){
        return faculties;
    }
}
