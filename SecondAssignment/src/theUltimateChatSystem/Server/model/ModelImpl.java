package theUltimateChatSystem.Server.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
    private List<String> usernames;

    public ModelImpl() {
        this.usernames = new ArrayList<>();
    }

    @Override
    public void addUserName(String username) {
        if (isConnectionPossible(username)) {
            usernames.add(username);
        }
    }

    @Override
    public void removeUserName(String userName) {
        usernames.remove(userName);
    }

    @Override
    public boolean isConnectionPossible(String userName) {
        return  !usernames.contains(userName) ;

    }
}
