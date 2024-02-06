package main.model.utils.list;

public interface IMyList<T> {
    void add(T item);

    T getAt(int index);

    void removeAt(int index);

    void clear();

    int count();
}
