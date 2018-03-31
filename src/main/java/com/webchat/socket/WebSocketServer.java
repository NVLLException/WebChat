package com.webchat.socket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer {
    private Session session;
    private static CopyOnWriteArraySet<WebSocketServer> sessionSet = new CopyOnWriteArraySet();
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        sessionSet.add(this);
        System.out.println("new session adding!");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.err.println("error exception");
        error.printStackTrace();
    }

    @OnClose
    public void onClose(){
        sessionSet.remove(this);
        System.out.println("session move out!");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("reciving client messages " + message);
    }

    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    public static void sendInfo() throws IOException{
        if(sessionSet.size() > 0){
            sessionSet.iterator().next().sendMessage("fuck");
        }
    }
}
