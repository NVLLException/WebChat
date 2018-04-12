package com.webchat.socket;


import com.alibaba.fastjson.JSONObject;
import com.webchat.common.SocketUtil;
import com.webchat.message.Message;

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

    public void onMessage(String messageStr, Session session){
        Message message = JSONObject.parseObject(messageStr, Message.class);
        String toId = message.getTo();
        Session toSession = SocketUtil.getSession(toId);
        if(toSession == null){
            return;
            //todo to persist the message
        }
        sendMessage(message, toSession);
    }
    public void sendMessage(Message message, Session session){
        try {
            session.getBasicRemote().sendText(JSONObject.toJSONString(message));
        } catch (Exception e){
            System.err.println("Send message error");
            e.printStackTrace();
        }
    }
}
