package temperature.mediator;

public interface Subject {
    void addListener(Listener lstnr);
    void removeListener(Listener lstnr);
}
