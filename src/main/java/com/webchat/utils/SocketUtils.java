package com.webchat.utils;


import javax.websocket.Session;
import java.util.*;

import com.webchat.socket.WebSocketServer;

public class SocketUtils {
    private volatile static Map<String,WebSocketServer> sessionMap;
    static{
        sessionMap = new HashMap();
    }
    public static Map<String,WebSocketServer> getSessionMap(){
        if(sessionMap == null){
            synchronized (sessionMap){
                if(sessionMap == null)
                    sessionMap = new HashMap();
            }
        }
        return sessionMap;
    }

    public static String setSocket(WebSocketServer socket){
        if(socket == null)
            return null;
        if(sessionMap.containsValue(socket)){
            Set<String> keys = sessionMap.keySet();
            for(String key : keys){
             if(socket.equals(sessionMap.get(key))){
                 return key;
             }
            }
        } else {
            String uuid = UUID.randomUUID().toString();
            sessionMap.put(uuid, socket);
            return uuid;
        }
        return null;
    }

    public static Session getSocket(String uuid){
        if(uuid == null)
            return null;
        WebSocketServer socket = sessionMap.get(uuid);
        if(socket != null && socket.getSession() != null){
            if(socket.getSession().isOpen()){
                return socket.getSession();
            } else {
                sessionMap.remove(uuid);
                return null;
            }
        }
        return null;
    }

    public static void removeSocket(WebSocketServer socket){
        if(socket == null || !sessionMap.containsValue(socket)) return;
        else{
            for(String key : sessionMap.keySet()){
                if(socket.equals(sessionMap.get(key))){
                    sessionMap.remove(key);
                    break;
                }
            }
        }
    }

    public static boolean checkSessionIsAvaliable(Session session){
        return session!= null && session.isOpen();
    }
}
