package excercise;

public class RunExcercise {
    public static void main(String[] args) {
        BalancedReadWrite balancedReadWrite= new BalancedReadWrite();
        for (int i = 0; i < 10; i++) {
            Reader r = new Reader(balancedReadWrite,"R"+i);
            new Thread(r).start();
        }
        for (int i = 0; i < 4; i++) {
            Writer w = new Writer(balancedReadWrite, "W"+i);
            new Thread(w).start();
        }}
}
