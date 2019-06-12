package com.liying;

import javax.xml.ws.Service;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 创建者:小䶮
 */
public class ProcessHandle implements Runnable{
    private Socket socket;
    private Object service;

    public ProcessHandle(Object service,Socket socket ) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //请求的类
            //请求的方法
            //请求的参数
            RPCRequest rpcRequest =  (RPCRequest)objectInputStream.readObject();
            Object result = invoke(rpcRequest);

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    private Object invoke(RPCRequest rpcRequest) throws Exception{
        Object[] params = rpcRequest.getPrams();
        Class<?>[] types = new Class[params.length];
        for (int i=0;i<types.length;i++){
            types[i] = params[i].getClass();
        }

        Class clazz = Class.forName(rpcRequest.getClassname());
        Method method = clazz.getMethod(rpcRequest.getMothodName(),types);
        Object result = method.invoke(service,params);
        return  result;
    }
}
