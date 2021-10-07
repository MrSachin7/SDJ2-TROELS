package theUltimateChatSystem.Client.model;

public interface LoginModel {
    boolean isConnectionPossible(String username);

    void addUser(String username, String password);
}
