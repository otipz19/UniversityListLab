package main.utils;

public interface MyList {
    public void add(Object object);
    public Object getAt(int i);
    public void insertAt(int i, Object object);
    public void removeAt(int i);
    public void clear();
    public int count();
}
