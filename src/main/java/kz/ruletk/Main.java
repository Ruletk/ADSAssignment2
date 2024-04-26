package kz.ruletk;

import kz.ruletk.datatypes.MinHeap;
import kz.ruletk.list.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>(new MyArrayList<Integer>());

        heap.insert(10);
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        heap.insert(4);
        heap.insert(4);

        System.out.println(heap.getMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.getMin());
    }
}
