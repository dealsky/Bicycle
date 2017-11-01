package com.bicycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainPageController {
    @RequestMapping("/Home")
    public ModelAndView findUser() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainpage");
        return modelAndView;
    }
}
