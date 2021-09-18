package temperature.mediator;

public interface Subject {
    void removeListener(Listener lstnr);
    void addListener(Listener lstnr);
}
