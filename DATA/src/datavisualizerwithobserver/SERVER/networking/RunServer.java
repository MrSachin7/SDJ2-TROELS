package datavisualizerwithobserver.SERVER.networking;

import datavisualizerwithobserver.SERVER.model.DataRandomizerManager;

public class RunServer {
    public static void main(String[] args) {
        SocketServer ss = new SocketServer(new DataRandomizerManager());
        ss.startServer();
    }
}
