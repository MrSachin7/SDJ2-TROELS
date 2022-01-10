package queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueADTTest {

    private QueueADT<String> q;
    @BeforeEach
    public void createQueue(){
         q = new SimpleBoundedArrayQueueA<>(5);
    }


    @Test
    public void addedElementIsInQueue() {
        //Arrange
//        QueueADT<String> q = new SimpleBoundedArrayQueueCorrect<>(5);
        //Act
        q.enqueue("A");
        //Assert
        assertTrue(q.contains("A"));
    }

    @Test
    public void addMultipleElementsToQueue() {
//        QueueADT<String> q = new SimpleBoundedArrayQueueCorrect<>(5);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        q.enqueue("E");
        assertTrue(q.contains("A"));
        assertTrue(q.contains("B"));
        assertTrue(q.contains("C"));
        assertTrue(q.contains("D"));
        assertTrue(q.contains("E"));
    }

    @Test
    public void sizeIsFourAfterAddingFourELements(){
//        QueueADT<String> q = new SimpleBoundedArrayQueueCorrect<>(5);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        assertTrue(4==q.size());
        assertEquals(4,q.size());
    }
    @Test
    public void nullArgumentResultsInIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,()->q.enqueue(null));
    }
    @Test
    public void fullQueueResultsInIllegalStateException(){
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        q.enqueue("E");
        assertThrows(IllegalStateException.class,()->q.enqueue("SixthElement"));
    }
    @Test
    public void emptyQueueDoesntContainElement(){
        assertFalse(q.contains("A"));
    }

}