package tests.model.utils;

import main.model.exceptions.MyListIndexOutOfBoundsException;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class is used to represent an our list test.
 */
class MyListTest {
    @Test
    public void constructorCreatesCopyOfArgumentArray() {
        Integer[] values = {1, 2, 3};
        IMyList<Integer> list = new MyList<>(values);

        values[0] = 69;

        assertEquals(values.length, list.count());
        assertNotEquals(values[0], list.getAt(0));
    }
    /**
     * This method is used to test the add method.
     */
    @Test
    public void addAddsObjectsToEmptyList() {
        Integer[] values = {1, 2, 3};
        IMyList<Integer> list = new MyList<>(values.length);

        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        assertEquals(values.length, list.count());
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], list.getAt(i));
        }
    }
    /**
     * This method is used to test the add method.
     */
    @Test
    public void addResizesInnerArray() {
        Integer[] values = {1, 2, 3, 4, 5, 6};
        IMyList<Integer> list = new MyList<>(3);

        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        assertEquals(values.length, list.count());
        for (int i = 0; i < list.count(); i++) {
            assertEquals(values[i], list.getAt(i));
        }
    }

    @Test
    public void clearClearsArray() {
        Integer[] values = {1, 2, 3};
        IMyList<Integer> list = new MyList<>(values);

        list.clear();
        assertEquals(0, list.count());
    }

    @Test
    public void removeAtRemovesObjectOnValidIndex() {
        Integer[] beforeRemove = {1, 2, 3, 4, 5};
        IMyList<Integer> list = new MyList<>(beforeRemove);
        Integer[] afterRemove = {1, 2, 4, 5};
        int indexToRemove = 2;

        list.removeAt(indexToRemove);

        assertEquals(afterRemove.length, list.count());
        for(int i = 0; i < list.count(); i++){
            assertEquals(afterRemove[i], list.getAt(i));
        }
    }

    @Test
    public void removeAtRemovesFromRightEdgeValid(){
        Integer[] startValues = {1, 2, 3, 4, 5};
        IMyList<Integer> list = new MyList<>(startValues);

        for(int i = startValues.length - 1; i >= 0; i--){
            list.removeAt(i);
        }

        assertEquals(0, list.count());
    }

    @Test
    public void removeAtKeepsHeadValid(){
        Integer[] startValues = {1, 2, 3, 4, 5};
        IMyList<Integer> list = new MyList<>(startValues);
        for(int i = startValues.length - 1; i >= 0; i--){
            list.removeAt(i);
        }

        Integer[] newValues = {5, 4, 3, 2, 1};
        for(int i = 0; i < newValues.length; i++){
            list.add(newValues[i]);
        }

        assertEquals(newValues.length, list.count());
        for(int i = 0; i < list.count(); i++){
            assertEquals(newValues[i], list.getAt(i));
        }
    }

    @Test
    public void removeAtThrowsExceptionOnInvalidIndex() {
        Integer[] values = {1, 2, 3};
        IMyList<Integer> list = new MyList<>(values);
        int invalidIndex = 69;

        assertThrows(MyListIndexOutOfBoundsException.class, () -> list.removeAt(invalidIndex));
    }

    @Test
    public void sort_DoesNotThrowInvalidCastException_OnDefaultConstructor(){
        Integer[] values = {3, 2, 1, 4, 5};
        IMyList<Integer> list = new MyList<>();
        for(Integer i: values){
            list.add(i);
        }
        Integer[] expected = Arrays.copyOf(values, values.length);
        Arrays.sort(expected);

        assertDoesNotThrow(() -> list.sort(Integer::compare));

        assertEquals(expected.length, list.count());
        for(int i = 0; i < list.count(); i++){
            assertEquals(expected[i], list.getAt(i));
        }
    }
}