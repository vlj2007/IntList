package pro.sky.IntList;

import org.junit.jupiter.api.Test;
import pro.sky.IntList.exception.InvalidIndexException;
import pro.sky.IntList.exception.NullItemException;

import static org.junit.jupiter.api.Assertions.*;

class IntListImplTest {

    private final IntListImpl IntListImpl = new IntListImpl();
    private final IntListImpl otherIntListImpl = new IntListImpl();

    Integer expectedInt1 = 1;
    Integer expectedInt2 = 2;

    @Test
    void testToString() {
        IntListImpl.add(expectedInt1);
        IntListImpl.add(expectedInt2);
        String expected = "list=[1, 2, null, null, null, null, null, null, null, null]";
        String actual = IntListImpl.toString();
        assertEquals(expected, actual);
    }

    @Test
    void add() {
        assertEquals(expectedInt1, IntListImpl.add(expectedInt1));
    }

    @Test
    void testAdd() {
        IntListImpl.add(expectedInt1);
        IntListImpl.add(expectedInt2);
        assertEquals(2, IntListImpl.size());

    }

    @Test
    void set() {
        IntListImpl.add(0, expectedInt1);
        IntListImpl.set(0, expectedInt2);
        assertTrue(IntListImpl.contains(expectedInt2));
        assertFalse(IntListImpl.contains(expectedInt1));
        assertThrows(NullItemException.class, () -> IntListImpl.set(0, (Integer) null));
        assertThrows(InvalidIndexException.class, () -> IntListImpl.set(11, expectedInt1));
    }

    @Test
    void remove() {
        IntListImpl.add(expectedInt1);
        IntListImpl.remove(expectedInt1);
        assertEquals(expectedInt1, IntListImpl.get(0));
    }

    @Test
    void testRemove() {
        IntListImpl.add(0, expectedInt1);
        IntListImpl.remove(0);
        assertFalse(IntListImpl.contains(expectedInt1));
        assertThrows(InvalidIndexException.class, () -> IntListImpl.remove(2));
    }

    @Test
    void contains() {
        IntListImpl.add(expectedInt1);
        assertTrue(IntListImpl.contains(expectedInt1));
    }

    @Test
    void indexOf() {
        IntListImpl.add(expectedInt1);
        IntListImpl.add(expectedInt2);
        assertEquals(0, IntListImpl.indexOf(expectedInt1));
    }

    @Test
    void lastIndexOf() {
        IntListImpl.add(expectedInt1);
        IntListImpl.add(expectedInt2);
        assertEquals(0, IntListImpl.indexOf(expectedInt1));
    }

    @Test
    void get() {
        IntListImpl.add(expectedInt1);
        assertTrue(IntListImpl.get(0).equals(expectedInt1));
        assertFalse(IntListImpl.get(0).equals(expectedInt2));
        assertThrows(InvalidIndexException.class, () -> IntListImpl.get(-5));
    }

    @Test
    void testEquals() {
        IntListImpl.add(expectedInt1);
        otherIntListImpl.add(expectedInt1);
        assertTrue(IntListImpl.equals(otherIntListImpl));
    }

    @Test
    void size() {
        IntListImpl.add(expectedInt1);
        IntListImpl.add(expectedInt2);
        assertEquals(2, IntListImpl.size());

    }

    @Test
    void isEmpty() {
        assertTrue(IntListImpl.isEmpty());
        IntListImpl.add(expectedInt1);
        assertFalse(IntListImpl.isEmpty());
    }

    @Test
    void clear() {
        IntListImpl.add(expectedInt1);
        IntListImpl.add(expectedInt2);
        IntListImpl.clear();
        assertEquals(IntListImpl.size(), 0);
    }

    @Test
    void toArray() {
        IntListImpl.add(expectedInt1);
        IntListImpl.add(expectedInt2);
        Integer[] expectedArray = {1, 2, null, null, null, null, null, null, null, null};
        Integer[] actualArray = {1, 2, null, null, null, null, null, null, null, null};
        assertArrayEquals(expectedArray, actualArray);
    }
}
