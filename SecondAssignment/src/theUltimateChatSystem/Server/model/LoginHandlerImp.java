package theUltimateChatSystem.Server.model;

import theUltimateChatSystem.shared.User;
import theUltimateChatSystem.shared.UserList;

import java.util.ArrayList;

public class LoginHandlerImp implements LoginHandler{

    private UserList everyUsers;

    public LoginHandlerImp()
    {
        everyUsers= new UserList();
    }
    @Override
    public void addUser(User user) {
        everyUsers.addUser(user);
    }

    @Override
    public void removeUser(User user) {
        everyUsers.removeUser(user);
    }

    @Override
    public boolean isConnectionPossible(String userName) {
        return !(everyUsers.allUserNames().contains(userName));
    }

}
