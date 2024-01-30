package main.utils.list;

import main.exceptions.*;

import java.util.Arrays;

abstract class MyObjectList {
    private Object[] items;
    private int head;

    protected MyObjectList(Object... items) {
        this.items = Arrays.copyOf(items, items.length);
        head = items.length;
    }

    protected MyObjectList() {
        this(7);
    }

    protected MyObjectList(int startSize) {
        items = new Object[startSize];
    }

    protected void addObject(Object object) {
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

    protected Object getObjectAt(int index) {
        try {
            return items[index];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new MyListIndexOutOfBoundsException(index);
        }
    }

    /*
    This method throws ArrayIndexOutOfBoundsException on valid index,
    if primitive types are stored inside MyList.
    This caused by the way JVM handles boxing, as it seems.
     */
    protected void removeObjectAt(int index) {
        try{
            items[index] = null;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new MyListIndexOutOfBoundsException(index);
        }
    }

    public void clear() {
        for(int i = 0; i < head; i++){
            items[i] = null;
        }
        head = 0;
    }

    public int count() {
        return head;
    }
}
