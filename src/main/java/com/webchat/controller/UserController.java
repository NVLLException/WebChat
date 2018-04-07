package com.webchat.controller;

import com.webchat.entity.User;
import com.webchat.service.UserService;
import com.webchat.common.HttpUtil;
import com.webchat.common.WcConstant;
import com.webchat.common.WcResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/webChat")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("/user/login");
        return modelAndView;
    }

    @RequestMapping("/validateLoginName")
    public void validateLoginName(HttpServletRequest request, HttpServletResponse response){
        String loginName = request.getParameter("loginName");
        WcResponse wcResponse = new WcResponse();
        Boolean isValid = userService.validateLoginName(loginName);
        wcResponse.succ();
        if(!isValid){
            wcResponse.addError("Login name has bean used.");
        }
        HttpUtil.ajaxSendResponse(response, wcResponse);
    }

    @RequestMapping("/validateLoginInfo")
    public void validateLoginInfo(HttpServletRequest request, HttpServletResponse response){
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        WcResponse wcResponse = new WcResponse();
        User user = userService.retrieveUser(loginName, password);
        wcResponse.succ();
        if(user == null){
            wcResponse.addError("Login name or password is not correct.");
        } else {
            request.getSession().setAttribute(WcConstant.USER, user);
        }
        HttpUtil.ajaxSendResponse(response, wcResponse);
    }

    @RequestMapping("/doLogin")
    public void doLogin(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("/user/login");

    }
}
