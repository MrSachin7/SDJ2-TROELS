package guardsman;

import valuable.Valuable;

public interface TreasureRoomDoor {

    void add(Valuable valuable);

    Valuable retrieve() throws Exception;

    void readValuables();

    void acquireRead();
    void acquireWrite();
    void releaseRead();
    void releaseWrite();
}
