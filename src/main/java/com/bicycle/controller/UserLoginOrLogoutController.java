package com.bicycle.controller;

import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserLoginOrLogoutController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login.do")
    public @ResponseBody Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map<String, Object> map = new HashMap<>();
        String userAcc = request.getParameter("userAcc");
        String userPass = request.getParameter("userPass");
        HttpSession httpSession = request.getSession();
        Map<String, Object> statusMap = userService.isModuleReg(userAcc, userPass);
        if(statusMap.get("status").equals("right")){
            map.put("meg", "ok");
            //  设置session
            ModuleUser moduleUser = (ModuleUser) userService.getModuleUserByAcc(userAcc).get(0);
            httpSession.setAttribute("user", moduleUser);
            //  更新最近登录时间
            userService.updateUserLastLoginTimeByAcc(moduleUser.getUserid());
        } else if(statusMap.get("status").equals("null")){
            map.put("meg", "null");
        } else if(statusMap.get("status").equals("passError")){
            map.put("meg", "passError");
        }
        return map;
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:Home";
    }

    @RequestMapping("/register.do")
    public @ResponseBody Map<String, Object> register(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map<String, Object> map = new HashMap<>();
        ModuleUser moduleUser = new ModuleUser();
        String userAcc = request.getParameter("userAcc");
        String userPass = request.getParameter("userPass");
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        moduleUser.setUseracc(userAcc);
        moduleUser.setUserpass(userPass);
        moduleUser.setUsername(userName);
        moduleUser.setUseremail(userEmail);

        List<ModuleUser> moduleUser1 = userService.getModuleUserByAcc(userAcc);
        if(moduleUser1.size() != 0) {
            map.put("meg", "null");
        } else {
            moduleUser1 = userService.getModuleUserByEmail(userEmail);
            if(moduleUser1.size() != 0) {
                map.put("meg", "emailError");
            } else {
                map.put("meg", "right");
                //  将用户增加到数据库
                userService.insertModuleUser(moduleUser);
            }
        }
        return map;
    }

    @RequestMapping("/register.in")
    public String registerIn(HttpServletRequest request, HttpSession httpSession) {
        String userAcc = request.getParameter("userAcc");
        ModuleUser moduleUser = (ModuleUser) userService.getModuleUserByAcc(userAcc).get(0);
        userService.updateUserLastLoginTimeByAcc(moduleUser.getUserid());
        httpSession.setAttribute("user", moduleUser);
        return "mainpage";
    }

    @RequestMapping("/register.userAcc")
    public @ResponseBody Map<String, Object> registerAcc(@RequestParam String userAcc) {
        Map<String, Object> map = new HashMap<>();
        List list = userService.getModuleUserByAcc(userAcc);
        if(list.size() == 0) {
            map.put("message", "right");
        } else {
            map.put("message", "error");
        }
        return map;
    }

    @RequestMapping("/register.userEmail")
    public @ResponseBody Map<String, Object> registerEmail(@RequestParam String userEmail) {
        Map<String, Object> map = new HashMap<>();
        List list = userService.getModuleUserByEmail(userEmail);
        if(list.size() == 0) {
            map.put("message", "right");
        } else {
            map.put("message", "error");
        }
        return map;
    }


}
