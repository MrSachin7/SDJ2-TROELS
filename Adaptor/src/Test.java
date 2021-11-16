public class Test {
    public static void main(String[] args) {
        StringQueue queue = new Queue(5);
        queue.enqueue("A");

        queue.enqueue("B");

        queue.enqueue("C");

        queue.enqueue("D");

        queue.enqueue("E");

        queue.enqueue("F");
        System.out.println(queue);
    }
}
