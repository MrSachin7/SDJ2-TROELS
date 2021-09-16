public class test {
    public static void main(String[] args) {
        Thermometer t1= new Thermometer("t1",15);
        Thread thread = new Thread(t1);
        thread.start();
    }
}
