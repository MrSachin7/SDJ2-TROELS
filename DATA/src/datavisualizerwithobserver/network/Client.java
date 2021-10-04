package datavisualizerwithobserver.network;

import shared.Subject;

public interface Client extends Subject {
    double[] update();
    void startClient();
}
