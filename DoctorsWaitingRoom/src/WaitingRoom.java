import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements Runnable, PropertyChangeSubject {
    private PropertyChangeSupport support;


    public WaitingRoom()
    {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void run() {
        int counter=-1;
        while (true)
        {
            try {
                counter++;
                System.out.println("Dinggggggg, The number is    "+counter);
                support.firePropertyChange("Counter increased", null, counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
