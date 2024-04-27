package kz.ruletk.datatypes;

import kz.ruletk.list.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
    Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>(new MyArrayList<Integer>());
    }

    @Test
    void testEmpty() {
        Assertions.assertTrue(stack.empty());
    }

    @Test
    void testSize() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        Assertions.assertEquals(10, stack.size());
    }

    @Test
    void testPeek() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        Assertions.assertEquals(9, stack.peek());
    }

    @Test
    void testPush() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        Assertions.assertEquals(10, stack.size());
    }

    @Test
    void testPop() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        Assertions.assertEquals(10, stack.pop());
        Assertions.assertEquals(9, stack.size());
    }
}