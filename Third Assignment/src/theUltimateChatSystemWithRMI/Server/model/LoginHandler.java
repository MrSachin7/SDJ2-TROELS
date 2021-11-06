package theUltimateChatSystemWithRMI.Server.model;

import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;

import java.util.List;

public interface LoginHandler   {
    boolean addUser(User user);

    boolean isConnectionPossible(String userName)  ;

    boolean isLoginPossible(User arg)  ;

    List<String> getAllUsers() ;
    void addActiveUser(User user);
    void removeActiveUser(User user);

}
