package com.webchat.controller;

import com.webchat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/webChat")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("/user/login");
        return modelAndView;
    }
}
