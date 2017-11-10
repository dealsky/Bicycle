package com.bicycle.filter;

import com.bicycle.dao.entity.ModuleManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManagerLoginHandlerIntercepter implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        ModuleManager moduleManager = (ModuleManager) httpServletRequest.getSession().getAttribute("manager");
        if(moduleManager != null) {
            return true;
        } else {
            httpServletResponse.sendRedirect("/Bicycle/Administer/");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
