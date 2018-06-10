package com.bicycle.controller.user;

import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "userInfo", method = RequestMethod.POST)
    public String upUserInfo( HttpSession session, ModuleUser user) {
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");

        user.setUserid(moduleUser.getUserid());
        userService.updateUserInfo(user);

        ModuleUser moduleUser2 = userService.getModuleUserById(moduleUser.getUserid());
        session.setAttribute("user", moduleUser2);
        return "redirect:userInfo";
    }
}
