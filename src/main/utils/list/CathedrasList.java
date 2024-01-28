package main.utils.list;

import main.entities.Cathedra;

public class CathedrasList extends MyList implements ICathedrasList {
    @Override
    public Cathedra getAt(int i){
        return (Cathedra) super.getAt(i);
    }

    @Override
    public void add(Cathedra cathedra) {
        super.add(cathedra);
    }

    @Override
    public void insertAt(int i, Cathedra cathedra) {
        super.insertAt(i, cathedra);
    }
}
