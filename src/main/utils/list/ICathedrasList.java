package main.utils.list;

import main.entities.Cathedra;

public interface ICathedrasList {
    void add(Cathedra cathedra);

    Cathedra getAt(int i);

    void insertAt(int i, Cathedra cathedra);

    void removeAt(int i);

    void clear();

    int count();
}
