package excercise;

public class Writer implements Runnable {
    private BalancedReadWrite sharedResourceController;
    private String name;

    public Writer(BalancedReadWrite sharedResourceController, String name) {
        this.sharedResourceController = sharedResourceController;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(name +" wants to write..");
            sharedResourceController.acquireWrite();
            sharedResourceController.doWrite();
            System.out.println(name+" changed teh variable to "+sharedResourceController.doRead());
            sharedResourceController.releaseWrite();
        }
    }
}
