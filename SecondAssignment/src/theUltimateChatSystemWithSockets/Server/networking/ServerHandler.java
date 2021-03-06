package theUltimateChatSystemWithSockets.Server.networking;

import theUltimateChatSystemWithSockets.Server.model.ChatHandler;
import theUltimateChatSystemWithSockets.Server.model.LoginHandler;
import theUltimateChatSystemWithSockets.shared.Message;
import theUltimateChatSystemWithSockets.shared.PrivateMessage;
import theUltimateChatSystemWithSockets.shared.User;
import theUltimateChatSystemWithSockets.shared.utils.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ServerHandler implements Runnable {

    private Socket socket;
    private ChatHandler chatHandler;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    private User user;
    private ConnectionPool pool;
    private LoginHandler loginHandler;

    public ServerHandler(Socket socket, ChatHandler chatHandler, LoginHandler loginHandler, ConnectionPool pool) {
        this.socket = socket;
        this.pool = pool;
        this.chatHandler = chatHandler;
        this.loginHandler = loginHandler;


        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {                                                                   // try should be outside the while(true) to not print the stacktrace forever.
            while (true) {
                Request request = (Request) inFromClient.readObject();
                if ("connectionRequest".equals(request.getType())) {                // switch case would have been better.......
                    String temp = (String) request.getArg();
                    if (loginHandler.isConnectionPossible(temp)) {
                        outToClient.writeObject(new Request("connectionRequest", true));
//                        pool.broadCastUsername(temp);
                    } else {
                        outToClient.writeObject(new Request("connectionRequest", false));
                    }
                    break;
                    //socket.close();

                } else if ("Listener".equals(request.getType())) {
                    this.user = (User) request.getArg();
                    // todo conn pool stuff
                    pool.addConnection(this);

                    //  chatHandler.addListener("addMessage", this::messageAdded);
//                    model.addListener("userAdded", this::userAdded);
//                    model.addListener("userRemoved", this::userRemoved);
                } else if ("getMessage".equals(request.getType())) {
                    List<Message> temp = chatHandler.getMessages();
                    outToClient.writeObject(new Request("getMessage", temp));
                    break;
                } else if ("addMessage".equals(request.getType())) {
                    chatHandler.addMessage((Message) request.getArg());
                    pool.broadcastToAll((Message) request.getArg());
                    break;
                }
//
//
                else if ("addUser".equals(request.getType())) {

                    boolean temp = loginHandler.addUser((User) request.getArg());
                    outToClient.writeObject(new Request("addUser", temp));
                    break;

                } else if ("isLoginPossible".equals(request.getType())) {
                    User user = (User) request.getArg();
                    boolean temp = loginHandler.isLoginPossible(user);
                    outToClient.writeObject(new Request("isLoginPossible", temp));
                    if (temp) {
                        // setUser(user);
                        this.user = user;
                        pool.broadCastUsername(user.getUserName());
                    }
                    break;

                } else if ("getUserList".equals(request.getType())) {
                    outToClient.writeObject(new Request("getUserList", loginHandler.getAllUsers()));
                    break;
                } else if ("addPrivateMessage".equals(request.getType())) {
                    //  chatHandler.addPrivateMessage((Object[]) request.getArg());
                    chatHandler.addPrivateMessage((PrivateMessage) request.getArg());
                    //  outToClient.writeObject(new Request(null,null));
                    pool.broadCastPrivateMessage((PrivateMessage) request.getArg());
                    outToClient.writeObject(new Request(null, null));
                    break;
                    //  pool.boradcast()
                } else if ("getUsersMessage".equals(request.getType())) {
                    List<Message> privateMessages = chatHandler.getPrivateMessage((PrivateMessage) request.getArg());
                    outToClient.writeObject(new Request("getUsersMessage", privateMessages));
                    break;

                }
//                else if ("addPrivateMessage".equals(request.getType())){
//                    String username1 =((String[]) request.getArg())[0];
//                    String username2= ((String[]) request.getArg())[1];
//                    outToClient.writeObject(new Request("doesPrivateMessageExists",chatHandler.doesPrivateMessageExists(username1,username2)));
//                }

            }

            socket.close();
        } catch (IOException e) {
            //loginHandler.removeUser(this.user);
            System.out.println("Socket has been disconnected");
            pool.removeConnection(this);
            pool.broadcastUserDisconnected(getUserName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

//    private void messageAdded(PropertyChangeEvent event) {
//        Message temp = (Message) event.getNewValue();
//        try {
//            //  System.out.println(userName);
//            outToClient.writeObject(new Request("addMessage", temp));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void sendMessageToClient(Message message) {

        try {
            outToClient.writeObject(new Request("addMessage", message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        if (user == null) {
            return "";
        } else {
            return user.getUserName();
        }
    }

    public void sendUsersToClient(String userName) {
        try {
            outToClient.writeObject(new Request("userAdded", userName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRemovedUserToClient(String username) {
        try {
            outToClient.writeObject(new Request("userRemoved", username));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPrivateMessageToClient(Message message) {
        {
            try {
                outToClient.writeObject(new Request("addPrivateMessage", message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
