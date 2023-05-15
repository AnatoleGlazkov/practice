package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/** The type ImplementQueueUsingStacksTest */
public class ImplementQueueUsingStacksTest {

    @Test
    void implementQueueUsingStacks() {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(8);
        queue.pop();
        queue.push(3);
        Assertions.assertEquals(8, queue.peek());
        Assertions.assertEquals(8, queue.pop());
        queue.push(5);
        Assertions.assertEquals(3, queue.pop());

        Assertions.assertFalse(queue.empty());
    }

    static class MyQueue {

        final Stack<Integer> stk1;
        final Stack<Integer> stk2;

        public MyQueue() {
            stk1 = new Stack<>();
            stk2 = new Stack<>();
        }

        public void push(int x) {
            while (!stk1.empty()) {
                stk2.push(stk1.pop());
            }
            stk1.clear();

            stk1.push(x);
            while (!stk2.empty()) {
                stk1.push(stk2.pop());
            }
            stk2.clear();
        }

        public int pop() {
            return stk1.pop();
        }

        public int peek() {
            return stk1.peek();
        }

        public boolean empty() {
            return stk1.empty();
        }
    }
}