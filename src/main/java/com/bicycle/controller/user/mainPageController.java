package com.bicycle.controller.user;

import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class mainPageController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String redirectHome() {
        return "redirect:Home";
    }

    @RequestMapping("/Home")
    public ModelAndView findUser() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainpage");
        return modelAndView;
    }

    @RequestMapping(value = "/login.action")
    public @ResponseBody
    Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        httpSession.removeAttribute("user");
        return "redirect:Home";
    }

    @RequestMapping("/register.action")
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

    @RequestMapping("/GetWeather.action")
    public @ResponseBody Map<String, Object> getWeather() throws IOException {
        Map<String, Object> map = new HashMap<>();
        URL u=new URL("http://route.showapi.com/9-5?showapi_appid=46304&from=5&lng=121.56&lat=29.86&needMoreDay=&needIndex=&needHourData=&need3HourForcast=&needAlarm=&showapi_sign=b121570716a84dabbb0143ad58f76c18");
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray();
        map.put("weather", new String(b,"utf-8"));
        return map;
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
}