package theUltimateChatSystemWithRMI.Server.model;

import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.UserList;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

public class LoginHandlerImp implements LoginHandler, Serializable {

    private UserList everyUsers;

    public LoginHandlerImp() throws RemoteException {
        everyUsers = new UserList();
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
    public void removeUser(User user) {
        everyUsers.removeUser(user);
    }

    @Override
    public boolean isConnectionPossible(String userName) {
        return !(everyUsers.allUserNames().contains(userName));
    }

    @Override
    public boolean isLoginPossible(User user) {
        System.out.println("Is login possible method is called");
        System.out.println(everyUsers.contains(user) + " is returned");
        return everyUsers.contains(user);
    }

    @Override
    public List<String> getAllUsers() {
        return everyUsers.allUserNames();
    }

}
