package main.utils.list;

import main.exceptions.*;

import java.util.Arrays;

public class MyList implements IMyList {
    private Object[] items;
    private int head;

    public MyList(Object... items) {
        this.items = Arrays.copyOf(items, items.length);
    }

    public MyList() {
        this(7);
    }

    public MyList(int startSize) {
        items = new Object[startSize];
    }

    @Override
    public void add(Object object) {
        items[head++] = object;
        if (isItemsFull()) {
            resize();
        }
    }

    private boolean isItemsFull() {
        return head == items.length;
    }

    private void resize() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public Object getAt(int i) {
        try {
            return items[i];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new MyListIndexOutOfBoundsException(i);
        }
    }

    /*
    This method throws ArrayIndexOutOfBoundsException on valid index,
    if primitive types are stored inside MyList.
    This caused by the way JVM handles boxing, as it seems.
     */
    @Override
    public void insertAt(int i, Object object) {
        try {
            items[i] = object;
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new MyListIndexOutOfBoundsException(i);
        }
    }

    /*
    This method throws ArrayIndexOutOfBoundsException on valid index,
    if primitive types are stored inside MyList.
    This caused by the way JVM handles boxing, as it seems.
     */
    @Override
    public void removeAt(int i) {
        try{
            items[i] = null;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new MyListIndexOutOfBoundsException(i);
        }
    }

    @Override
    public void clear() {
        for(int i = 0; i < head; i++){
            items[i] = null;
        }
    }

    @Override
    public int count() {
        return head;
    }
}
