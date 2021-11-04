package theUltimateChatSystemWithSockets.Server;

import theUltimateChatSystemWithSockets.Server.model.ChatHandlerImpl;
import theUltimateChatSystemWithSockets.Server.model.LoginHandlerImp;
import theUltimateChatSystemWithSockets.Server.networking.SocketServer;

public class RunServer {
    public static void main(String[] args) {
        SocketServer ss = new SocketServer(new ChatHandlerImpl(),new LoginHandlerImp());
        ss.startServer();
   //    HashMap<String,Integer mp = new HashMap<>();
    }
}
