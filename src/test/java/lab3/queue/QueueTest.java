package test.java.lab3.queue;

import main.java.lab3.queue.BasicQueue;
import main.java.lab3.queue.CircularQueue;
import main.java.lab3.queue.PriorityQueueImpl;
import main.java.lab3.queue.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testBasicQueue() {
        Queue<String> queue = new BasicQueue<>();

        // Initially empty
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        // Add elements
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        // Check size
        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());

        // Remove elements
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("C", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testCircularQueue() {
        Queue<String> queue = new CircularQueue<>(3);
        queue.enqueue("X");
        queue.enqueue("Y");
        queue.enqueue("Z");

        // Test full condition
        assertThrows(IllegalStateException.class, () -> queue.enqueue("W"));

        // Test dequeue
        assertEquals("X", queue.dequeue());
        queue.enqueue("W");
        assertEquals("Y", queue.dequeue());
        assertEquals("Z", queue.dequeue());
        assertEquals("W", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueueImpl<>();
        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(3);

        // Priority order
        assertEquals(3, queue.size());
        assertEquals(1, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
