package excercise;

public class Reader implements Runnable{
    private BalancedReadWrite sharedResourceController;
    private String name;

    public Reader(BalancedReadWrite sharedResourceController, String name) {
        this.sharedResourceController = sharedResourceController;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(name+ " wants to read");
            sharedResourceController.acquireRead();
            int i =sharedResourceController.doRead();
            System.out.println(name+ " read "+i);
            sharedResourceController.releaseRead();

        }
    }
}
