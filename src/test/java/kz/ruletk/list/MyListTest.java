package kz.ruletk.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public abstract class MyListTest {
    private static final Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    abstract <T extends Comparable<T>> MyList<T> createInstance();

    @Test
    public void testAdd() {
        MyList<Integer> list = createInstance();
        for (int i : array)
            list.add(i);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testAddIndex() {
        MyList<Integer> list = createInstance();

        for (int i = 0; i < 3; i++)
            list.add(i);
        for (int i = 5; i <= 9; i++)
            list.add(i);

        list.add(4, 3);
        list.add(3, 3);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testAddFirst() {
        MyList<Integer> list = createInstance();
        for (int i = 9; i >= 0; i--)
            list.addFirst(array[i]);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testAddLast() {
        MyList<Integer> list = createInstance();
        for (int i : array)
            list.addLast(i);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testSet() {
        MyList<Integer> list = createInstance();
        for (int i = 9; i >= 0; i--)
            list.add(i);
        for (int i : array)
            list.set(i, i);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testGet() {
        MyList<Integer> list = createInstance();
        for (int i : array)
            list.add(i);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testGetFirst() {
        MyList<Integer> list = createInstance();
        for (int i : array)
            list.add(i);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testGetLast() {
        MyList<Integer> list = createInstance();
        for (int i : array)
            list.add(i);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testRemove() {
        MyList<Integer> list = createInstance();
        Integer[] arr = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        for (int i : arr)
            list.add(i);

        list.remove(6);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testRemoveFirst() {
        MyList<Integer> list = createInstance();
        Integer[] arr = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr)
            list.add(i);

        list.removeFirst();

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testRemoveLast() {
        MyList<Integer> list = createInstance();
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        for (int i : arr)
            list.add(i);

        list.removeLast();

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testSort() {
        MyList<Integer> list = createInstance();
        Integer[] arr = {9, 7, 8, 4, 5, 6, 3, 2, 1, 0};
        for (int i : arr)
            list.add(i);

        list.sort();

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testIndexOf() {
        MyList<Integer> list = createInstance();
        Integer[] arr = {0, 1, 2, 3, 4, 6, 5, 6, 7, 8, 9, 9};
        for (int i : arr)
            list.add(i);

        Assertions.assertEquals(4, list.indexOf(4));
    }

    @Test
    public void testLastIndexOf() {
        MyList<Integer> list = createInstance();
        Integer[] arr = {0, 1, 2, 3, 4, 6, 5, 4, 6, 7, 8, 9};
        for (int i : arr)
            list.add(i);

        Assertions.assertEquals(7, list.lastIndexOf(4));
    }

    @Test
    public void testExists() {
        MyList<Integer> list = createInstance();
        Integer[] arr = {0, 1, 2, 3, 4, 6, 5, 4, 6, 7, 8, 9};
        for (int i : arr)
            list.add(i);

        Assertions.assertTrue(list.exists(4));
    }

    @Test
    public void testNotExists() {
        MyList<Integer> list = createInstance();

        Assertions.assertFalse(list.exists(100));
    }

    @Test
    public void testToArray() {
        MyList<Integer> list = createInstance();
        for (int i : array)
            list.add(i);

        Assertions.assertArrayEquals(array, list.toArray());
    }

    @Test
    public void testClear() {
        MyList<Integer> list = createInstance();
        Integer[] arr = {};
        for (int i : array)
            list.add(i);

        list.clear();

        Assertions.assertArrayEquals(arr, list.toArray());
    }

    @Test
    public void testSize() {
        MyList<Integer> list = createInstance();
        for (int i : array)
            list.add(i);

        Assertions.assertEquals(array.length, list.size());
    }
}
