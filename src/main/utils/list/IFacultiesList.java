package main.utils.list;

import main.entities.*;

public interface IFacultiesList {
    void add(Faculty faculty);

    Faculty getAt(int i);

    void insertAt(int i, Faculty faculty);

    void removeAt(int i);

    void clear();

    int count();
}
