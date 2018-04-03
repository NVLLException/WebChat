package com.webchat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/webChat")
public class SocketController {
    @RequestMapping("/doChat")
    public ModelAndView socket(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView("/chat/chat");
        return modelAndView;
    }
}
