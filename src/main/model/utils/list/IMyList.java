package main.model.utils.list;

public interface IMyList<T> {
    void add(T item);

    T getAt(int index);

    void removeAt(int index);

    void remove(T item);

    void clear();

    int count();

    IMyList<T> copy();
}
