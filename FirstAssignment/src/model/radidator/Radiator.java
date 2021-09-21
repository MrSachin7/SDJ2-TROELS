package model.radidator;

import model.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements PropertyChangeSubject {
    private RadiatorState currentState;
    private PropertyChangeSupport support;

    public Radiator() {
        if (currentState == null) {
            currentState = new OffState();
        }
        support= new PropertyChangeSupport(this);
    }

    public void turnUp() {
        currentState.turnUp(this);
        support.firePropertyChange("Power changed", null, getPower());
    }

    public void turnDown() {
        currentState.turnDown(this);
        support.firePropertyChange("Power changed", null, getPower());
    }

    public int getPower() {
        return currentState.getPower();
    }

    void setPowerState(RadiatorState state) {
        currentState = state;
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
}
