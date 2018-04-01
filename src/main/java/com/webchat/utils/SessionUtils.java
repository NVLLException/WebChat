package com.webchat.utils;


import javax.websocket.Session;
import java.util.*;

public class SessionUtils {
    private volatile static Map<Object,Object> sessionMap;
    static{
        sessionMap = new HashMap();
    }
    public static Map<Object,Object> getSessionMap(){
        if(sessionMap == null){
            synchronized (sessionMap){
                if(sessionMap == null)
                    sessionMap = new HashMap();
            }
        }
        return sessionMap;
    }

    public static String setSession(Session session){
        if(session == null)
            return null;
        if(sessionMap.containsValue(session)){
            Set<Object> keys = sessionMap.keySet();
            for(Object key : keys){
             if(session.equals(sessionMap.get(key))){
                 return (String)key;
             }
            }
        } else {
            String uuid = UUID.randomUUID().toString();
            sessionMap.put(uuid, session);
            return uuid;
        }
        return null;
    }

    public static Session getSession(String uuid){
        if(uuid == null)
            return null;
        Session session = (Session)sessionMap.get(uuid);
        if(session != null ){
            if(session.isOpen()){
                return session;
            } else {
                sessionMap.remove(uuid);
                return null;
            }
        }
        return null;
    }

    public static void removeSession(Session session){
        if(session != null && sessionMap.containsValue(session)){
            for(Object key : sessionMap.keySet()){
                if(session.equals(sessionMap.get(key))){
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
