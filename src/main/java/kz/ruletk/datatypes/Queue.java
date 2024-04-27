package kz.ruletk.datatypes;


import kz.ruletk.list.MyList;

/**
 * Represents a queue data structure that follows the First-In-First-Out (FIFO) principle.
 *
 * @param <T> the type of elements stored in the queue, which must extend Comparable
 */
public class Queue<T extends Comparable<T>> {
    private final MyList<T> list;

    public Queue(MyList<T> list) {
        this.list = list;
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return true if the queue is empty, otherwise false
     */
    public boolean empty() {
        return size() == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return list.size();
    }

    /**
     * Retrieves, but does not remove, the head of the queue.
     *
     * @return the element at the front of the queue
     */
    public T peek() {
        return list.getLast();
    }

    /**
     * Inserts the specified element into the queue.
     *
     * @param t the element to be added to the queue
     */
    public void enqueue(T t) {
        list.addFirst(t);
    }

    /**
     * Retrieves and removes the head of the queue.
     *
     * @return the element removed from the queue
     */
    public T dequeue() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }
}
