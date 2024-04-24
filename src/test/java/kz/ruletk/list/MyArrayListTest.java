package kz.ruletk.list;

public class MyArrayListTest extends MyListTest {
    @Override
    protected <T extends Comparable<T>> MyList<T> createInstance() {
        return new MyArrayList<>();
    }
}
