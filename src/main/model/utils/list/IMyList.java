package main.model.utils.list;

import main.model.utils.sorting.IComparator;

public interface IMyList<T> {
    void add(T item);

    void addRange(T... items);

    void addRange(IMyList<T> items);

    T getAt(int index);

    void removeAt(int index);

    void remove(T item);

    void clear();

    int count();

    void sort(IComparator<T> comparator);
}
