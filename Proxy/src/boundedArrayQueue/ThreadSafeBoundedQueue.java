package boundedArrayQueue;

public class ThreadSafeBoundedQueue implements StringQueue {

    private StringQueue stringQueue;

    public  ThreadSafeBoundedQueue(int cap) {
        stringQueue = new BoundedArrayQueue(cap);
    }

    @Override
    public synchronized void enqueue(String element) {
            stringQueue.enqueue(element);
    }

    @Override
    public String dequeue() {
        synchronized (this) {
            return stringQueue.dequeue();
        }
    }

    @Override
    public String first() {
        synchronized (this) {
            return stringQueue.first();
        }
    }

    @Override
    public int size() {
        synchronized (this) {
            return stringQueue.size();
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (this) {
            return stringQueue.isEmpty();
        }
    }

    @Override
    public int indexOf(String element) {
        synchronized (this) {
            return stringQueue.indexOf(element);
        }
    }

    @Override
    public boolean contains(String element) {
        synchronized (this) {
            return stringQueue.contains(element);
        }
    }
}
