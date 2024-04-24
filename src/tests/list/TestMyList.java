package tests.list;

import list.MyLinkedList;
import list.MyList;

public abstract class TestMyList {
    private static final Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void testIt() {
        testAdd();
        testAddFirst();
        testAddIndex();
        testAddFirst();
        testAddLast();
        testSet();
        testGet();
        testGetFirst();
        testGetLast();
        testRemove();
        testRemoveFirst();
        testRemoveLast();
        testSort();
        testIndexOf();
        testLastIndexOf();
        testExists();
        testNotExists();
        testToArray();
        testClear();
        testSize();
    }

    public static void testAdd() {
        MyList<Integer> list = createList();
        for (int i : array)
            list.add(i);

        assertEqual(list, array);
    }

    public static void testAddIndex() {
        MyList<Integer> list = createList();

        for(int i = 0; i < 3; i++)
            list.add(i);
        for (int i = 5; i <= 9; i++)
            list.add(i);

        list.add(4, 4);
        list.add(3, 3);

        assertEqual(list, array);
    }

    public static void testAddFirst() {
        MyList<Integer> list = createList();
        for (int i = 8; i >=0; i--)
            list.addFirst(array[i]);

        assertEqual(list, array);
    }

    public static void testAddLast() {
        MyList<Integer> list = createList();
        for(int i : array)
            list.addLast(i);

        assertEqual(list, array);
    }

    public static void testSet() {
        MyList<Integer> list = createList();
        for (int i = 9; i >= 0; i--)
            list.add(i);
        for (int i : array)
            list.set(i, i);

        assertEqual(list, array);
    }

    public static void testGet() {
        MyList<Integer> list = createList();
        for (int i : array)
            list.add(i);

        assertEqual(list.get(3), array[3]);
    }

    public static void testGetFirst() {
        MyList<Integer> list = createList();
        for (int i : array)
            list.add(i);

        assertEqual(list.getFirst(), array[0]);
    }

    public static void testGetLast() {
        MyList<Integer> list = createList();
        for (int i : array)
            list.add(i);

        assertEqual(list.getLast(), array[9]);
    }

    public static void testRemove() {
        MyList<Integer> list = createList();
        Integer[] arr = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        for (int i : arr)
            list.add(i);

        list.remove(6);

        assertEqual(list, array);
    }

    public static void testRemoveFirst() {
        MyList<Integer> list = createList();
        Integer[] arr = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr)
            list.add(i);

        list.removeFirst();

        assertEqual(list, array);
    }

    public static void testRemoveLast() {
        MyList<Integer> list = createList();
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        for (int i : arr)
            list.add(i);

        list.removeLast();

        assertEqual(list, array);
    }

    public static void testSort() {
        MyList<Integer> list = createList();
        Integer[] arr = {9, 7, 8, 4, 5, 6, 3, 2, 1, 0};
        for (int i : arr)
            list.add(i);

        list.sort();

        assertEqual(list, array);
    }

    public static void testIndexOf() {
        MyList<Integer> list = createList();
        Integer[] arr = {0, 1, 2, 3, 4, 6, 5, 6, 7, 8, 9, 9};
        for (int i : arr)
            list.add(i);

        assertEqual(list.indexOf(4), 4);
    }

    public static void testLastIndexOf() {
        MyList<Integer> list = createList();
        Integer[] arr = {0, 1, 2, 3, 4, 6, 5, 4, 6, 7, 8, 9};
        for (int i : arr)
            list.add(i);

        assertEqual(list.lastIndexOf(4), 7);
    }

    public static void testExists() {
        MyList<Integer> list = createList();
        Integer[] arr = {0, 1, 2, 3, 4, 6, 5, 4, 6, 7, 8, 9};
        for (int i : arr)
            list.add(i);

        assertEqual(list.exists(4), true);
    }

    public static void testNotExists() {
        MyList<Integer> list = createList();

        assertEqual(list.exists(10), false);
    }

    public static void testToArray() {
        MyList<Integer> list = createList();
        for (int i : array)
            list.add(i);

        assertEqual(list, array);
    }

    public static void testClear() {
        MyList<Integer> list = createList();
        Integer[] arr = {};
        for (int i : array)
            list.add(i);

        list.clear();
        assertEqual(list, arr);
    }

    public static void testSize() {
        MyList<Integer> list = createList();
        for (int i : array)
            list.add(i);

        assertEqual(list.size(), array.length);
    }

    private static <T extends Comparable<T>> void assertEqual(MyList<T> list, T[] array) {
        try {
            assert list.toArray() == array;
            System.out.println("Passed");
        } catch (Exception e) {
            System.out.println("Test failed: " + e);
        }
    }

    private static <T extends Comparable<T>> void assertEqual(T item1, T item2) {
        try {
            assert item1.equals(item2);
        } catch (Exception e) {
            System.out.println("Test failed: " + e);
        }
    }

    private static <T extends Comparable<T>> void assertEqual(T[] item1, T[] item2) {
        try {
            assert item1 == item2;
        } catch (Exception e) {
            System.out.println("Test failed: " + e);
        }
    }

    protected static <T extends Comparable<T>> MyList<T> createList() {
        return new MyLinkedList<>();
    }
}
