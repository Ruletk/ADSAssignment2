package kz.ruletk.list;

/**
 * A custom list interface representing a collection of elements.
 * This interface provides methods to manipulate the elements within the list.
 *
 * @param <T> the type of elements stored in the list, which must extend both Object and implement Comparable
 */
public interface MyList<T extends Object & Comparable<T>> extends Iterable<T> {
    /**
     * Method add element "item" to the end of the list.
     *
     * @param item Element which will be added to the list
     */
    void add(T item);

    /**
     * Method that add element to the index position.
     * New element will be located in index that wrote
     *
     * @param item  Element which will be added to the list
     * @param index Index where new element will be located.
     */
    void add(T item, int index);

    /**
     * Method add element to the start of the list,
     * moving other elements forward.
     *
     * @param item Element which will be added to the list
     */
    void addFirst(T item);

    /**
     * Method that add element to the end of the list
     * This method have same functionality with {@link #add(T)} method
     *
     * @param item Element which will be added to the list
     */
    void addLast(T item);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param item  the element to be stored at the specified position
     * @param index the index of the element to replace
     */
    void set(T item, int index);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     */
    T get(int index);

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     */
    T getFirst();

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     */
    T getLast();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     */
    void remove(int index);

    /**
     * Removes the first element from this list.
     */
    void removeFirst();

    /**
     * Removes the last element from this list.
     */
    void removeLast();

    /**
     * Sorts the elements of this list into ascending order, according to their natural ordering.
     */
    void sort();

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     *
     * @param item the element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int indexOf(T item);

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
     *
     * @param item the element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int lastIndexOf(T item);

    /**
     * Checks if the specified element exists in this list.
     *
     * @param item the element to check for existence
     * @return true if the specified element exists in this list, otherwise false
     */
    boolean exists(T item);

    /**
     * Returns an array representation of list.
     *
     * @return an array containing all the elements in this list in proper sequence
     */
    T[] toArray();

    /**
     * Removes all the elements from this list.
     */
    void clear();

    /**
     * Returns the list size.
     *
     * @return the number of elements in this list
     */
    int size();
}
