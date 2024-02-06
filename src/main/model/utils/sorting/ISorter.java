package main.model.utils.sorting;

public interface ISorter<T> {
    public void sort(T[] arr, IComparator<T> comparator);

    public void sort(T[] arr, int left, int right, IComparator<T> comparator);
}
