package main.utils.list;

public interface IMyList {
    void add(Object object);

    Object getAt(int i);

    void insertAt(int i, Object object);

    void removeAt(int i);

    void clear();

    int count();
}
