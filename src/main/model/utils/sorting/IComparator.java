package main.model.utils.sorting;

public interface IComparator<T> {
    int compare(T left, T right);
}
