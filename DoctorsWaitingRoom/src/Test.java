import javax.swing.plaf.TableHeaderUI;

public class Test {
    public static void main(String[] args) {
        WaitingRoom waitingRoom = new WaitingRoom();
        Patient[] patients = new Patient[5];

        Thread thread2 = new Thread(()->
        {
            for (int i = 0; i < patients.length; i++) {
                patients[i]= new Patient(i,waitingRoom);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        Thread thread1 = new Thread(waitingRoom);
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
    }
}
