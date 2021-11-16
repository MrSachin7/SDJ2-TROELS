public class StartTaskExample {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new TaskProducer(queue,i)).start();
            new Thread(new TaskConsumer(queue,i)).start();
        }
    }
}
