package main.utils;

import main.entities.Cathedra;
import main.entities.Teacher;

public interface CathedrasList {
    void add(Cathedra cathedra);

    Cathedra getAt(int i);

    void insertAt(int i, Cathedra cathedra);

    void removeAt(int i);

    void clear();

    int count();
}
