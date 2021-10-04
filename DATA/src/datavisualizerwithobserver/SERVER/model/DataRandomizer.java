package datavisualizerwithobserver.SERVER.model;

import shared.Subject;

public interface DataRandomizer extends Subject {
    double[] update();
}
