package tests.list;


import list.MyArrayList;
import list.MyList;

public class TestMyArrayList extends TestMyList {
    protected static <T extends Comparable<T>> MyList<T> createList() {
        return new MyArrayList<>();
    }
}
