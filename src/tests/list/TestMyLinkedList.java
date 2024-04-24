package tests.list;

import list.MyLinkedList;
import list.MyList;

public class TestMyLinkedList extends TestMyList{
    protected static <T extends Comparable<T>> MyList<T> createList() {
        return new MyLinkedList<>();
    }
}
