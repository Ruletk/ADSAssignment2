package kz.ruletk.list;


public class MyLinkedListTest extends MyListTest {

    @Override
    protected <T extends Comparable<T>> MyList<T> createInstance() {
        return new MyLinkedList<>();
    }
}
