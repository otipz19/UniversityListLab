package main.model.utils.list;

public class MyList<T> extends MyObjectList implements IMyList<T> {
    public MyList() {
        this(7);
    }

    public MyList(int startSize) {
        super(startSize);
    }

    public MyList(T... items) {
        super(items);
    }

    public void add(T item) {
        super.addObject(item);
    }

    public void addRange(IMyList<T> range) {
        for (int i = 0; i < range.count(); i++) {
            add(range.getAt(i));
        }
    }

    public void addRange(T... range) {
        for (int i = 0; i < range.length; i++) {
            add(range[i]);
        }
    }

    public T getAt(int index) {
        return (T) super.getObjectAt(index);
    }

    @Override
    public void removeAt(int index) {
        super.removeObjectAt(index);
    }

    @Override
    public void remove(T item) {
        super.removeObject(item);
    }
}
