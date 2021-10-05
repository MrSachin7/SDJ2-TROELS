package theUltimateChatSystem.Server.networking;

import theUltimateChatSystem.Server.model.ModelImpl;

public class RunServer {
    public static void main(String[] args) {
        SocketServer ss = new SocketServer(new ModelImpl());
        ss.startServer();
    }
}
