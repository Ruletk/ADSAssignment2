package kz.ruletk.datatypes;


import kz.ruletk.list.MyList;

/**
 * Stack data type. Using LIFO (Last In First Out) principle.
 *
 * @param <T> Type of the elements into the stack, that implements comparable interface
 */
public class Stack<T extends Comparable<T>> {
    private final MyList<T> list;

    public Stack(MyList<T> list) {
        this.list = list;
    }

    /**
     * @return true if stack is empty, false otherwise
     */
    public boolean empty() {
        return size() == 0;
    }


    /**
     * Count of elements in the stack.
     *
     * @return Size of the stack.
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns the last element that pushed into the stack.
     *
     * @return The top element in the stack
     */
    public T peek() {
        return list.getLast();
    }


    /**
     * Add new element to the stack.
     *
     * @param t Insert t into the stack
     */
    public void push(T t) {
        list.addLast(t);
    }

    /**
     * Receive the top element of the stack
     * and removing it from stack.
     *
     * @return The top element in the stack
     */
    public T pop() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }
}
