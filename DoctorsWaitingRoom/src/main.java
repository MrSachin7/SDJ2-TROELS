public class main {
    public static void main(String[] args) {
        WaitingRoom waitingRoom = new WaitingRoom();
        Patient[] patients = new Patient[10];
        for (int i = 0; i < patients.length; i++)

            try {

                patients[i] = new Patient(i, waitingRoom);
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        Thread thread = new Thread(waitingRoom);
        thread.start();

    }
}
