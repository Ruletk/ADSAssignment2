package kz.ruletk.list;

import java.util.Iterator;

public class MyArrayList<T extends Object & Comparable<T>> implements MyList<T> {
    private static final int DEFAULT_SIZE = 5;

    private T[] array;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Illegal ArrayList size: " + size);
        this.array = createArray(size);
    }

    @Override
    public void add(T item) {
        if (size >= array.length)
            increaseSize();
        array[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (size == 0 || index == size) {
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
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++)
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    swapped = true;
                }
            if (!swapped)
                break;
        }
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
        T[] arr = createArray(size);
        if (size >= 0) System.arraycopy(array, 0, arr, 0, size);
        return arr;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++)
            str.append(array[i]).append(" ");
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    @SuppressWarnings(value = "unchecked")
    private T[] createArray(int size) {
        return (T[]) new Object[size];
    }

    private void increaseSize() {
        T[] newArr = createArray(size * 2);
        if (size >= 0) System.arraycopy(array, 0, newArr, 0, size);
        array = newArr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
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
