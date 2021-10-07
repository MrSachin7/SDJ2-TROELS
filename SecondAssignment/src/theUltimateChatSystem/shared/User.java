package theUltimateChatSystem.shared;

import java.io.Serializable;
import java.util.Objects;
import java.util.SplittableRandom;

public class User implements Serializable {
    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName=userName;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof User)){
            return false;
        }
        User temp =(User) obj;
        return temp.getUserName().equals(userName) && temp.getPassword().equals(password);
    }
}
