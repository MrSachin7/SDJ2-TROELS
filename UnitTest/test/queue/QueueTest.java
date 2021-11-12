package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueTest {
    @Test
    public void addedElementIsInQueue() {
        // arrange
        QueueADT<String> q = new BoundedArrayQueue<>(5);
        //act
        q.enqueue("A");
        //assert
        assertTrue(q.contains("A"));
    }

    @Test
    public void addMultipleElementToQueue() {
        QueueADT<String> q = new BoundedArrayQueue<>(5);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        assertTrue(q.contains("A"));
        assertTrue(q.contains("B"));
        assertTrue(q.contains("C"));
        assertTrue(q.contains("D"));


    }

}