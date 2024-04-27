package kz.ruletk.datatypes;

import kz.ruletk.list.MyList;

/**
 * Represents a min-heap data structure, which is a complete binary tree where each node is smaller than its children.
 *
 * @param <T> the type of elements stored in the min-heap, which must extend Comparable
 */
public class MinHeap<T extends Comparable<T>> {
    private final MyList<T> list;

    public MinHeap(MyList<T> list) {
        list.add(null);
        this.list = list;
    }

    /**
     * Checks whether the min-heap is empty.
     *
     * @return true if the min-heap is empty, otherwise false
     */
    public boolean empty() {
        return size() == 1;
    }

    /**
     * Returns the number of elements in the min-heap.
     *
     * @return the number of elements in the min-heap
     */
    public int size() {
        return list.size() - 1;
    }

    /**
     * Retrieves the minimum element from the min-heap without removing it.
     *
     * @return the minimum element in the min-heap
     */
    public T getMin() {
        return list.get(1);
    }

    /**
     * Retrieves and removes the minimum element from the min-heap.
     *
     * @return the minimum element removed from the min-heap
     */
    public T extractMin() {
        T min = getMin();
        list.set(list.getLast(), 1);
        list.removeLast();
        heapify(1);
        return min;
    }

    /**
     * Inserts a new element into the minheap.
     *
     * @param t the element to be inserted into the min-heap
     */
    public void insert(T t) {
        list.addLast(t);
        traverseUp(t, list.size() - 1);
    }

    private void heapify(int index) {
        int l = leftChildOf(index);
        int r = rightChildOf(index);
        int go;
        if (l >= size() || r >= size())
            return;
        if (l >= size())
            go = r;
        else if (r >= size())
            go = l;
        else
            go = list.get(l).compareTo(list.get(r)) > 0 ? r : l;

        if (list.get(index).compareTo(list.get(go)) > 0) {
            swap(index, go);
            heapify(go);
        }
    }

    private void traverseUp(T t, int index) {
        int parent = parentOf(index);
        if (list.get(parent).compareTo(t) > 0) {
            swap(parent, index);
            traverseUp(t, parent);
        }
    }

    /**
     * @param index Index of the parent node
     * @return Index of the left child of node
     */
    private int leftChildOf(int index) {
        return index * 2 - 1;
    }

    /**
     * @param index Index of the parent node
     * @return Index of the right child of node
     */
    private int rightChildOf(int index) {
        return index * 2;
    }

    /**
     * @param index Index of the children node
     * @return Index of the parent node
     */
    private int parentOf(int index) {
        if (index == 1)
            return 1;
        return index / 2;
    }

    /**
     * Swap two elements with following indexes.
     *
     * @param index1 Index of the first element
     * @param index2 Index of the second element
     */
    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(list.get(index2), index1);
        list.set(temp, index2);
    }

}
