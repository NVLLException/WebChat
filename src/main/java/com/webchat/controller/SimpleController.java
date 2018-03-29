package com.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")//request path
public class SimpleController {
    @RequestMapping("/index1")//requestpath
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/index");//forward jsp file
        modelAndView.addObject("name","A");
        return modelAndView;
    }
    @RequestMapping("/index2")
    public ModelAndView index2(){
        ModelAndView modelAndView = new ModelAndView("/index");//forward jsp file
        modelAndView.addObject("name","B");
        return modelAndView;
    }
}
