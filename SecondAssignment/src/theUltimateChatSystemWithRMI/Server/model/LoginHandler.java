package theUltimateChatSystemWithRMI.Server.model;

import theUltimateChatSystemWithRMI.shared.User;


import java.util.List;

public interface LoginHandler   {
    boolean addUser(User user);

    void removeUser(User user) ;

    boolean isConnectionPossible(String userName)  ;

    boolean isLoginPossible(User arg)  ;

    List<String> getAllUsers() ;

}
