package main.exceptions;

public class MyListIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public MyListIndexOutOfBoundsException(int index){
        super(index);
    }
}
