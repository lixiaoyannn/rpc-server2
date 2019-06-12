package com.liying;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IHellloService hellloService = new HelloServiceImpl();
        RPCProxyServer proxyServer = new RPCProxyServer();
        proxyServer.publish(hellloService,8080);
    }
}
