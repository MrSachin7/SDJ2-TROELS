package server.model;

import shared.Subject;

public interface DataRandomizer extends Subject {
    void saveData(double[] data);
}
