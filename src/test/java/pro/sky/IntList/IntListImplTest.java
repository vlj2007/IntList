package pro.sky.IntList;

import org.junit.jupiter.api.Test;
import pro.sky.IntList.exception.InvalidIndexException;
import pro.sky.IntList.exception.NullItemException;

import static org.junit.jupiter.api.Assertions.*;

class IntListImplTest {

    private final IntListImpl IntListImpl = new IntListImpl();
    private final IntListImpl otherIntListImpl = new IntListImpl();

    String expectedStr1 = "строка1";
    String expectedStr2 = "строка2";

    @Test
    void testToString() {
        IntListImpl.add(expectedStr1);
        IntListImpl.add(expectedStr2);
        String expected = "list=[строка1, строка2, null, null, null, null, null, null, null, null]";
        String actual = IntListImpl.toString();
        assertEquals(expected, actual);
    }

    @Test
    void add() {
        assertEquals(expectedStr1, IntListImpl.add(expectedStr1));
    }

    @Test
    void testAdd() {
        IntListImpl.add(expectedStr1);
        IntListImpl.add(expectedStr2);
        assertEquals(2, IntListImpl.size());

    }

    @Test
    void set() {
        IntListImpl.add(0, expectedStr1);
        IntListImpl.set(0, expectedStr2);
        assertTrue(IntListImpl.contains(expectedStr2));
        assertFalse(IntListImpl.contains(expectedStr1));
        assertThrows(NullItemException.class, () -> IntListImpl.set(0, null));
        assertThrows(InvalidIndexException.class, () -> IntListImpl.set(11, expectedStr1));
    }

    @Test
    void remove() {
        IntListImpl.add(expectedStr1);
        IntListImpl.remove(expectedStr1);
        assertEquals(expectedStr1, IntListImpl.get(0));
    }

    @Test
    void testRemove() {
        IntListImpl.add(0, expectedStr1);
        IntListImpl.remove(0);
        assertFalse(IntListImpl.contains(expectedStr1));
        assertThrows(InvalidIndexException.class, () -> IntListImpl.remove(2));
    }

    @Test
    void contains() {
        IntListImpl.add(expectedStr1);
        assertTrue(IntListImpl.contains(expectedStr1));
    }

    @Test
    void indexOf() {
        IntListImpl.add(expectedStr1);
        IntListImpl.add(expectedStr2);
        assertEquals(0, IntListImpl.indexOf(expectedStr1));
    }

    @Test
    void lastIndexOf() {
        IntListImpl.add(expectedStr1);
        IntListImpl.add(expectedStr2);
        assertEquals(0, IntListImpl.indexOf(expectedStr1));
    }

    @Test
    void get() {
        IntListImpl.add(expectedStr1);
        assertTrue(IntListImpl.get(0).equals(expectedStr1));
        assertFalse(IntListImpl.get(0).equals(expectedStr2));
        assertThrows(InvalidIndexException.class, () -> IntListImpl.get(-5));
    }

    @Test
    void testEquals() {
        IntListImpl.add(expectedStr1);
        otherIntListImpl.add(expectedStr1);
        assertTrue(IntListImpl.equals(otherIntListImpl));
    }

    @Test
    void size() {
        IntListImpl.add(expectedStr1);
        IntListImpl.add(expectedStr2);
        assertEquals(2, IntListImpl.size());

    }

    @Test
    void isEmpty() {
        assertTrue(IntListImpl.isEmpty());
        IntListImpl.add(expectedStr1);
        assertFalse(IntListImpl.isEmpty());
    }

    @Test
    void clear() {
        IntListImpl.add(expectedStr1);
        IntListImpl.add(expectedStr2);
        IntListImpl.clear();
        assertEquals(IntListImpl.size(), 0);
    }

    @Test
    void toArray() {
        IntListImpl.add(expectedStr1);
        IntListImpl.add(expectedStr2);
        String[] expectedArray = {"строка1", "строка2", null, null, null, null, null, null, null, null};
        String[] actualArray = {"строка1", "строка2", null, null, null, null, null, null, null, null};
        assertArrayEquals(expectedArray, actualArray);
    }
}
