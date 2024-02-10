package main.model.utils.list;

public class MyList<T> extends MyObjectList implements IMyList<T>{
    public MyList(){
        this(7);
    }

    public MyList(int startSize){
        super(startSize);
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

    @Override
    public void remove(T item){
        super.removeObject(item);
    }
}
