package main.utils;

import main.entities.Cathedra;

public class CathedrasListImplementation extends MyListImplementation implements CathedrasList{
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
