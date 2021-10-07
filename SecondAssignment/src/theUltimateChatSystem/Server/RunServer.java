package theUltimateChatSystem.Server;

import theUltimateChatSystem.Server.model.LoginHandlerImp;
import theUltimateChatSystem.Server.model.ModelImpl;
import theUltimateChatSystem.Server.networking.SocketServer;

public class RunServer {
    public static void main(String[] args) {
        SocketServer ss = new SocketServer(new ModelImpl(),new LoginHandlerImp());
        ss.startServer();
    }
}
