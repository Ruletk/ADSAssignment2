package kz.ruletk.datatypes;


import kz.ruletk.list.MyList;

public class Stack<T extends Comparable<T>> implements DataType<T>{
    private final MyList<T> list;

    public Stack(MyList<T> list) {
        this.list = list;
    }

    public void push(T t) {
        list.addLast(t);
    }

    public T pop() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }

    public T get() {
        return list.getLast();
    }

    public int size() {
        return list.size();
    }
}
