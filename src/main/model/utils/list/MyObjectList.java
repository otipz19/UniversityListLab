package main.model.utils.list;

import main.model.exceptions.*;

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


    public void clear() {
        for(int i = 0; i < head; i++){
            items[i] = null;
        }
        head = 0;
    }

    public int count() {
        return head;
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
        validateIndex(index);
        return items[index];
    }

    protected void removeObjectAt(int index) {
        validateIndex(index);
        head--;
        if(index != head){
            for(int i = index; i < head; i++){
                items[i] = items[i + 1];
            }
        }
    }

    private void validateIndex(int index) {
        if(index < 0 || index >= head){
            throw new MyListIndexOutOfBoundsException(index);
        }
    }
}
