package tests;

import main.exceptions.MyListIndexOutOfBoundsException;
import main.utils.list.IMyList;
import main.utils.list.ITeachersList;
import main.utils.list.MyList;
import main.utils.list.TeachersList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    @Test
    public void constructorCreatesCopyOfArgumentArray() {
        int[] values = {1, 2, 3};
        IMyList list = new MyList(values);

        values[0] = 69;

        assertNotEquals(values[0], list.getAt(0));
    }

    @Test
    public void addAddsObjectsToEmptyList() {
        int[] values = {1, 2, 3};
        IMyList list = new MyList(values.length);

        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        assertEquals(values.length, list.count());
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], list.getAt(i));
        }
    }

    @Test
    public void addResizesInnerArray() {
        int[] values = {1, 2, 3, 4, 5, 6};
        IMyList list = new MyList(3);

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
        int[] values = {1, 2, 3};
        IMyList list = new MyList(values);

        list.clear();

        for (int i = 0; i < list.count(); i++) {
            assertNull(list.getAt(i));
        }
    }

    @Test
    public void insertAtInsertsObjectOnValidIndex() {
        Integer[] values = new Integer[3];
        Arrays.fill(values, 1);
        IMyList list = new MyList(values);
        int index = 1;
        int value = 69;

        list.insertAt(index, value);

        assertEquals(value, list.getAt(index));
    }

    @Test
    public void insertAtThrowsExceptionOnInvalidIndex() {
        int[] values = {1, 2, 3};
        IMyList list = new MyList(values);
        int invalidIndex = 69;
        int value = 69;

        assertThrows(MyListIndexOutOfBoundsException.class, () -> list.insertAt(invalidIndex, value));
    }

    @Test
    public void removeAtRemovesObjectOnValidIndex() {
        Integer[] values = new Integer[3];
        Arrays.fill(values, 1);
        IMyList list = new MyList(values);
        int index = 2;

        list.removeAt(index);

        assertNull(list.getAt(index));
    }

    @Test
    public void removeAtThrowsExceptionOnInvalidIndex() {
        int[] values = {1, 2, 3};
        IMyList list = new MyList(values);
        int invalidIndex = 69;

        assertThrows(MyListIndexOutOfBoundsException.class, () -> list.removeAt(invalidIndex));
    }
}