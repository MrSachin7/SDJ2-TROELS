package theUltimateChatSystemWithRMI.Server.model;

import theUltimateChatSystemWithRMI.Client.networking.Client;
import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.UserList;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

public class LoginHandlerImp implements LoginHandler, Serializable {

    private UserList everyUsers;
    private UserList activeUsers;

    public LoginHandlerImp()  {
        everyUsers = new UserList();
        activeUsers= new UserList();
        everyUsers.addUser(new User("Sachin","aa"));
        everyUsers.addUser(new User("Troels","aa"));
    }

    @Override
    public boolean addUser(User user) {
        everyUsers.addUser(user);
        System.out.println("USer added :" + user.getUserName());
//        for (int i = 0; i < everyUsers.size(); i++) {
//            System.out.println(everyUsers.get(i));
//        }
//        System.out.println(everyUsers);
        return true;
    }


    @Override
    public boolean isConnectionPossible(String userName) {
        return !(everyUsers.allUserNames().contains(userName));
    }

    @Override
    public boolean isLoginPossible(User user) {
        System.out.println("Is login possible method is called");
        System.out.println(everyUsers.contains(user) + " is returned");
        if (everyUsers.contains(user)){
            addActiveUser(user);
            return true;
        }
        return false;
    }

    @Override
    public List<String> getAllUsers() {
        return activeUsers.allUserNames();
    }

    @Override
    public void addActiveUser(User user) {
        activeUsers.addUser(user);
    }

    @Override
    public void removeActiveUser(User user) {
        activeUsers.removeUser(user);
    }

}
