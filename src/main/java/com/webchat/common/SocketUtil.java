package com.webchat.common;


import javax.websocket.Session;
import java.util.*;

import com.webchat.socket.WebSocketServer;

public class SocketUtil {
    private volatile static Map<Object,WebSocketServer> sessionMap;
    static{
        sessionMap = new HashMap();
    }
    public static Map<Object,WebSocketServer> getSessionMap(){
        if(sessionMap == null){
            synchronized (sessionMap){
                if(sessionMap == null)
                    sessionMap = new HashMap();
            }
        }
        return sessionMap;
    }

    public static Object setSocket(Object uuid, WebSocketServer socket){
        if(socket == null)
            return null;
        if(sessionMap.containsValue(socket)){
            Set<Object> keys = sessionMap.keySet();
            for(Object key : keys){
             if(socket.equals(sessionMap.get(key))){
                 return key;
             }
            }
        } else {
            sessionMap.put(uuid, socket);
            return uuid;
        }
        return null;
    }

    public static Session getSession(String uuid){
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
            for(Object key : sessionMap.keySet()){
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
