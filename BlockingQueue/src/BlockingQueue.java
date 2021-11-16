import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private int capacity;
    private Queue<Task> queue;

    public BlockingQueue(int cap) {
        queue = new LinkedList<>();
        capacity = cap;
    }

    public synchronized void add(Task task) {
        while (queue.size() >= capacity) {
            try {
                System.out.println("Queue was full....");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(task);
        notifyAll();

    }

    public synchronized Task retrieve() {
        while (queue.isEmpty()) {
            try {
                System.out.println("Queue was empty.....");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Task task = queue.poll();
        notifyAll();
        return task;
    }
}
