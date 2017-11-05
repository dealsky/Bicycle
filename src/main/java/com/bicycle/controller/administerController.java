package com.bicycle.controller;

import com.bicycle.dao.entity.ModuleManager;
import com.bicycle.service.ManagerService;
import com.bicycle.service.SiteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class administerController {

    @Resource
    private ManagerService managerService;

    @Resource
    private SiteService siteService;

    @RequestMapping("/Administer")
    public String administer() {
        return "administer";
    }

    @RequestMapping("/ManagerLogin.do")
    public @ResponseBody Map<String, Object> managerLogin(@RequestParam String managerAcc, @RequestParam String managerPass, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        List<ModuleManager> list = managerService.getManagerByAcc(managerAcc);
        if(list.size() != 0) {
            ModuleManager moduleManager = list.get(0);
            if(moduleManager.getMagpass().equals(managerPass)) {
                map.put("errorLog", "right");
                session.setAttribute("manager", moduleManager);
                ModuleManager moduleManager1 = new ModuleManager();
                moduleManager1.setMagid(moduleManager.getMagid());
                moduleManager1.setMaglastlogintime(new Date());
                managerService.updateManager(moduleManager1);
            } else {
                map.put("errorLog", "pass");
            }
        } else {
            map.put("errorLog", "noManager");
        }
        return map;
    }

    @RequestMapping("/ManagerLogout.do")
    public String managerLogout(HttpSession httpSession) {
        httpSession.removeAttribute("manager");
        return "administer";
    }

    @RequestMapping("/CountSite.do")
    public @ResponseBody Map<String, Integer> countSite() {
        Map<String, Integer> map = siteService.getSiteCount();
        return map;
    }
}
