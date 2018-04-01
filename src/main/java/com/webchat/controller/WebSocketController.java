package com.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/webChat")//request path
public class WebSocketController {
    @RequestMapping("/chat")
    public ModelAndView socket(){
        ModelAndView modelAndView = new ModelAndView("/chat/chat");
        return modelAndView;
    }
}
