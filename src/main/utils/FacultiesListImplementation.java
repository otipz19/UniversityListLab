package main.utils;

import main.entities.Faculty;

public class FacultiesListImplementation extends MyListImplementation implements FacultiesList {
    @Override
    public Faculty getAt(int i){
        return (Faculty) super.getAt(i);
    }

    @Override
    public void add(Faculty faculty) {
        super.add(faculty);
    }

    @Override
    public void insertAt(int i, Faculty faculty) {
        super.insertAt(i, faculty);
    }
}
