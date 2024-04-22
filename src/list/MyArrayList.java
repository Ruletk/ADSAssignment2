package list;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_SIZE = 5;

    private T[] array;
    private int size = 0;

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Illegal ArrayList size: " + size);
        this.array = (T[]) new Object[size];
    }

    @Override
    public void add(T item) {
        if (size >= array.length)
            increaseSize();
        array[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (size == 0) {
            add(item);
            return;
        }
        checkIndex(index);
        if (size >= array.length)
            increaseSize();

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(item, 0);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public void set(T item, int index) {
        checkIndex(index);
        array[index] = item;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public T getFirst() {
        return array[0];
    }

    @Override
    public T getLast() {
        return array[size - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        // TODO: Make sort
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++)
            if (item.equals(array[i]))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        for (int i = size - 1; i >= 0; i--)
            if (item.equals(array[i]))
                return i;
        return -1;
    }

    @Override
    public boolean exists(T item) {
        return indexOf(item) >= 0;
    }

    @Override
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        for (int i = 0; i < size; i++)
            arr[i] = array[i];
        return arr;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++)
            builder.append(array[i]).append(" ");
        return builder.toString();
    }

    private void increaseSize() {
        T[] newArr = (T[]) new Object[size * 2];
        for (int i = 0; i < size; i++)
            newArr[i] = array[i];
        array = newArr;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr(0);
    }

    private class Itr implements Iterator<T> {
        int cursor;

        public Itr(int cursor) {
            this.cursor = cursor;
        }

        @Override
        public boolean hasNext() {
            return size > cursor;
        }

        @Override
        public T next() {
            return array[cursor++];
        }
    }
}
