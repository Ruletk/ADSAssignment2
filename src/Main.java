import list.MyArrayList;
import list.MyLinkedList;
import list.MyList;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        testList();

    }

    private static void testList() {
        testAdd(new MyArrayList<>());
        testAdd(new MyLinkedList<>());

        testDelete(new MyLinkedList<>());
        testDelete(new MyArrayList<>());

        testGet(new MyLinkedList<>());
        testGet(new MyArrayList<>());

        testSet(new MyLinkedList<>());
        testSet(new MyArrayList<>());

        testIndexOf(new MyLinkedList<>());
        testIndexOf(new MyArrayList<>());

        testLastIndexOf(new MyLinkedList<>());
        testLastIndexOf(new MyArrayList<>());

        testExists(new MyLinkedList<>());
        testExists(new MyArrayList<>());
    }

    private static void testAdd(MyList<Integer> impl) {
        Integer[] arr = {0, 1, 2, 3, 4, 5};
        for (int i = 1; i <= 5; i++)
            impl.add(i);
        impl.addFirst(0);
        System.out.println(Arrays.equals(arr, impl.toArray()));
    }

    private static void testDelete(MyList<Integer> impl) {
        Integer[] arr = {1, 2, 3, 5, 6};
        for (int i = 1; i <= 6; i++)
            impl.add(i);
        impl.add(5);
        impl.removeLast();
        impl.remove(3);
        boolean res = Arrays.equals(arr, impl.toArray());
        if (!res)
            System.out.print(Arrays.toString(arr) + " | " + Arrays.toString(impl.toArray()));
        else
            System.out.println(res);
    }

    private static void testGet(MyList<Integer> impl) {
        for (int i = 0; i <= 10; i++)
            impl.add(i);

        boolean res = true;
        for (int i = 0; i < 10; i++)
            res = res && i == impl.get(i);
        System.out.println(res);
    }

    private static void testSet(MyList<Integer> impl) {
        Integer[] arr = {1, 2, 5, 4, 5};
        for (int i = 1; i <= 5; i++)
            impl.add(i);

        impl.set(5, 2);

        boolean res = Arrays.equals(arr, impl.toArray());
        if (!res)
            System.out.print(Arrays.toString(arr) + " | " + Arrays.toString(impl.toArray()));
        else
            System.out.println(res);
    }

    private static void testIndexOf(MyList<Integer> impl) {
        for (int i = 1; i <= 5; i++)
            impl.add(i);

        boolean res = impl.indexOf(4) == 3;
        System.out.println(res);
    }

    private static void testLastIndexOf(MyList<Integer> impl) {
        for (int i = 0; i < 2; i++) {
            impl.add(1);
            impl.add(2);
            impl.add(3);
        }

        boolean res = impl.lastIndexOf(2) == 4;
        System.out.println(res);
    }

    private static void testExists(MyList<Integer> impl) {
        for (int i = 0; i < 1000; i++)
            impl.add(i);

        boolean res = impl.exists(500);
        System.out.println(res);
    }

}
