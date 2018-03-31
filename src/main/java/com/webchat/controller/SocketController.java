package com.webchat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value="/websocket",method= RequestMethod.POST,consumes = "application/json")
public class SocketController {
    public String pushMessage(){
        return "fuck";
    }
}
