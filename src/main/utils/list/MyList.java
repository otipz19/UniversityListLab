package main.utils.list;

public class MyList<T> extends MyObjectList implements IMyList<T>{
    public MyList(){
        this(7);
    }

    public MyList(int startSize){
        super(7);
    }

    public MyList(T... items){
        super(items);
    }

    public void add(T item){
        super.addObject(item);
    }

    public T getAt(int index){
        return (T) super.getObjectAt(index);
    }

    @Override
    public void removeAt(int index) {
        super.removeObjectAt(index);
    }
}
