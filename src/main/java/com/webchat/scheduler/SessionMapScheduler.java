package com.webchat.scheduler;

import com.webchat.socket.WebSocketServer;
import com.webchat.common.SocketUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SessionMapScheduler {
    @Scheduled(cron="0 0/1 * * * ?")// every 1 mins
    public void clearTheClosedSession(){
        Map<String,WebSocketServer> socketMap = SocketUtil.getSessionMap();
        for(Object key : socketMap.keySet()){
            if(socketMap.get(key) != null && !socketMap.get(key).getSession().isOpen()){
                socketMap.remove(key);
            }
        }
    }
}
