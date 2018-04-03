package com.webchat.scheduler;

import com.webchat.socket.WebSocketServer;
import com.webchat.utils.SocketUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Map;

@Component
public class SessionMapScheduler {
    @Scheduled(cron="0 0/1 * * * ?")// every 1 mins
    public void clearTheClosedSession(){
        Map<String,WebSocketServer> sessionMap = SocketUtils.getSessionMap();
        for(Object key : sessionMap.keySet()){
            if(sessionMap.get(key) != null && !((Session)sessionMap.get(key)).isOpen()){
                sessionMap.remove(key);
            }
        }
    }
}
