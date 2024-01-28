package main.utils.list;

import main.entities.Faculty;

public class FacultiesList extends MyList implements IFacultiesList {
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
