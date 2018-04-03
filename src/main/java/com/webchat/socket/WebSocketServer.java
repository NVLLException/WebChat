package com.webchat.socket;

import com.webchat.utils.SocketUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer {
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @OnOpen
    public void onOpen(Session session){
        this.setSession(session);
        SocketUtils.setSocket(this);
        System.out.println("new session adding!");
        try{
            sendMessage("hello");
        } catch (Exception e){

        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.err.println("error exception");
        error.printStackTrace();
    }

    @OnClose
    public void onClose(){
        SocketUtils.removeSocket(this);
        System.out.println("session move out!");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        HandleMessage.getMessageInstance().onMessage(message, session);
    }

    public void sendMessage(String message) throws IOException{
        HandleMessage.getMessageInstance().sendMessage(message, getSession());
    }
}
