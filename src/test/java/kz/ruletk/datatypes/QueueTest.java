package kz.ruletk.datatypes;

import kz.ruletk.list.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
    Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>(new MyArrayList<Integer>());
    }

    @Test
    void empty() {
        Assertions.assertTrue(queue.empty());
    }

    @Test
    void size() {
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);

        Assertions.assertEquals(10, queue.size());
    }

    @Test
    void peek() {
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);

        Assertions.assertEquals(0, queue.peek());
    }

    @Test
    void enqueue() {
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);

        Assertions.assertEquals(10, queue.size());
    }

    @Test
    void dequeue() {
        for (int i = 0; i < 10; i++)
            queue.enqueue(i);

        Assertions.assertEquals(0, queue.dequeue());
        Assertions.assertEquals(9, queue.size());
    }
}