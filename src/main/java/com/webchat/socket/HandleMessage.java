package com.webchat.socket;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

public class HandleMessage {
    private static volatile HandleMessage self = null;

    public static HandleMessage getMessageInstance(){
        if(self == null){
            synchronized (HandleMessage.class){
                if(self == null)
                    self = new HandleMessage();
            }
        }
        return self;
    }

    public void onMessage(String message, Session session){
        System.out.println(message);
    }
    public void sendMessage(String message, Session session) throws IOException{
        session.getBasicRemote().sendText(message);
    }
}
