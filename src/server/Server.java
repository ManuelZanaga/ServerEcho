package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2000);
        while(true){
            new ServerTcp(ss.accept()).run();
        }
    }
    
}
