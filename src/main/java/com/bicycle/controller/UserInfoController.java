package com.bicycle.controller;

import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/User")
public class UserInfoController {

    @Resource
    private UserService userService;

    @RequestMapping("/UserInfo")
    public String userInfo(HttpSession httpSession) {
        ModuleUser moduleUser = (ModuleUser) httpSession.getAttribute("user");

        if(moduleUser == null) {
            return "redirect:Home";
        } else {
            return "userinfo";
        }
    }

    @RequestMapping("/UpEmail.do")
    public @ResponseBody Map<String, Object> upEmail(@RequestParam String userEmail, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<>();

        List list = userService.getModuleUserByEmail(userEmail);
        ModuleUser moduleUser = (ModuleUser) httpSession.getAttribute("user");
        ModuleUser moduleUser1 = null;
        if(list.size() != 0){
            moduleUser1 = (ModuleUser) list.get(0);
        }
        if(list.size() == 0 ||(list.size()==1 && moduleUser.getUserid().equals(moduleUser1.getUserid()))) {
            map.put("message", "success");
        } else {
            map.put("message", "error");
        }
        return map;
    }

    @RequestMapping("/upUserInfo.do")
    public String upUserInfo(HttpServletRequest request, HttpSession session) {
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        ModuleUser moduleUser1 = new ModuleUser();


        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userTel = request.getParameter("userTel");
        String userIdCard = request.getParameter("userIdCard");
        int userSex = request.getParameter("userSex").equals("female") ? 0 : 1;

        moduleUser1.setUserid(moduleUser.getUserid());
        moduleUser1.setUsername(userName);
        moduleUser1.setUseremail(userEmail);
        moduleUser1.setUsertel(userTel);
        moduleUser1.setUseridcard(userIdCard);
        moduleUser1.setUsersex(userSex);
        userService.updateUserInfo(moduleUser1);

        ModuleUser moduleUser2 = userService.getModuleUserById(moduleUser.getUserid());
        session.setAttribute("user", moduleUser2);
        return "redirect:UserInfo";
    }

    @RequestMapping("/changePass.pan")
    public @ResponseBody Map<String, Object> changePassPan(HttpSession session, @RequestParam String userPass) {
        Map<String, Object> map = new HashMap<>();
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(userService.panUserPass(moduleUser, userPass)) {
            map.put("message", "right");
        } else {
            map.put("message", "error");
        }
        return map;
    }

    @RequestMapping("/changePass.do")
    public @ResponseBody Map<String, Object> changePass(@RequestParam String userPass, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        userService.updateUserPass(moduleUser.getUserid(), userPass);
        ModuleUser moduleUser1 = userService.getModuleUserById(moduleUser.getUserid());
        session.setAttribute("user", moduleUser1);
        map.put("message", "success");
        return map;
    }

    @RequestMapping("/ChangeHeadPortrait.do")
    public String changeHeadPortrait(@RequestParam MultipartFile multipartFile, HttpSession session) throws IOException {
        String oldFileName = multipartFile.getOriginalFilename();
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        String newFileName = moduleUser.getUserid().toString() + "default" + oldFileName.substring(oldFileName.lastIndexOf("."));
        //File uploadPic = new java.io.File("F:/develop/uplaoad/temp/" + newFileName);
        File file = new File("userHp/" + newFileName);
        if(!file.exists()){
            file.mkdirs();
        }
        multipartFile.transferTo(file);
        System.out.println(System.getProperty("user.dir"));
        System.out.println(newFileName);
        return "redirect:UserInfo";
    }
}
