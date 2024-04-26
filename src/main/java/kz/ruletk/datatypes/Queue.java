package kz.ruletk.datatypes;


import kz.ruletk.list.MyList;

public class Queue<T extends Comparable<T>> {
    private final MyList<T> list;

    public Queue(MyList<T> list) {
        this.list = list;
    }

    public boolean empty() {
        return size() == 0;
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        return list.getLast();
    }

    public void enqueue(T t) {
        list.addFirst(t);
    }

    public T dequeue() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }
}
