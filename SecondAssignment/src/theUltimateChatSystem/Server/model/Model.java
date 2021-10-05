package theUltimateChatSystem.Server.model;

public interface Model {
    boolean isConnectionPossible(String userName);
    void addUserName(String userName);
    void removeUserName(String userName);
}
