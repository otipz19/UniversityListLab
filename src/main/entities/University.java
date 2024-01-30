package main.entities;

import main.utils.list.IMyList;

public class University {
    private IMyList<Faculty> faculties;

    public void setFaculties(IMyList<Faculty> faculties){
        this.faculties = faculties;
    }

    public IMyList<Faculty> getFaculties(){
        return faculties;
    }
}
