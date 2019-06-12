package com.liying;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建者:小䶮
 */
public class RPCProxyServer {
    ExecutorService executorService = Executors.newCachedThreadPool();
    public void publish(Object service,int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessHandle(service,socket));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
