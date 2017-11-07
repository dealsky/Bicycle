package com.bicycle.controller;

import com.bicycle.dao.entity.*;
import com.bicycle.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class AdministerController {

    @Resource
    private ManagerService managerService;

    @Resource
    private SiteService siteService;

    @Resource
    private BicycleService bicycleService;

    @Resource
    private ParkService parkService;

    @Resource
    private UserService userService;

    @Resource
    private RentedService rentedService;

    @RequestMapping("/Administer")
    public String administer() {
        return "administer";
    }

    @RequestMapping("/ManageBicycle")
    public String manageBicycle(HttpSession session) {
        if(session.getAttribute("manager") != null) {
            return "managebicycle";
        } else {
            return "redirect:Administer";
        }
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
        return "redirect:Administer";
    }

    @RequestMapping("/CountSite.do")
    public @ResponseBody Map<String, Integer> countSite() {
        Map<String, Integer> map = siteService.getSiteCount();
        return map;
    }

    @RequestMapping("/TableBicycle.do")
    public @ResponseBody List<Map> tableBicycle() {
        List<ModuleBicycle> list = bicycleService.getAllBicycle();
        List<Map> returnList = new ArrayList<>();
        for(int i = 0; i<list.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            ModuleBicycle moduleBicycle = list.get(i);
            map.put("bicycle", moduleBicycle);
            if(moduleBicycle.getBicborrowed() == 0) {
                List<ModulePark> list1 = parkService.getParkByBicId(moduleBicycle.getBicid());
                ModulePark modulePark = list1.get(0);
                ModuleSite moduleSite = siteService.getSiteById(modulePark.getSiteid());
                map.put("site", moduleSite);
                map.put("user", null);
            } else {
                List<ModuleRented> list1 = rentedService.getRentedByBicId(moduleBicycle.getBicid());
                ModuleRented moduleRented = list1.get(0);
                ModuleUser moduleUser = userService.getModuleUserById(moduleRented.getUserid());
                map.put("site", null);
                map.put("user", moduleUser);
            }
            returnList.add(map);
        }
        return returnList;
    }

    @RequestMapping("/InsertBicycle.do")
    public @ResponseBody Map<String, Object> insertBicycle(@RequestParam ModuleBicycle moduleBicycle) {
        Map<String, Object> map = new HashMap<>();
        bicycleService.updateBicycle(moduleBicycle);
        map.put("errorLog", "right");
        return map;
    }

    @RequestMapping("/JudgeSite.do")
    public @ResponseBody Map<String, Object> judgeSite(@RequestParam long siteNumber) {
        Map<String, Object> map = new HashMap<>();
        List<ModuleSite> list = siteService.getSiteByNumber(siteNumber);
        if(list.size() != 0) {
            map.put("errorLog", "right");
        } else {
            map.put("errorLog", "error");
        }
        return map;
    }

    @RequestMapping("/AddTable.do")
    public @ResponseBody Map<String, Object> addTable(@RequestParam String bicType, @RequestParam float bicPrice, @RequestParam long siteNumber,
                         @RequestParam Date bicBuyTime) {

        ModuleBicycle moduleBicycle = new ModuleBicycle();
        moduleBicycle.setBictype(bicType);
        moduleBicycle.setBicrentprice(bicPrice);
        moduleBicycle.setBicbuytime(bicBuyTime);
        moduleBicycle.setBicborrowed(0);
        moduleBicycle.setBicborrowedcount(0);

        bicycleService.insertBicycle(moduleBicycle);
        moduleBicycle.setBicnumber(moduleBicycle.getBicid() + 10000000);
        bicycleService.updateBicycle(moduleBicycle);

        ModulePark modulePark = new ModulePark();
        modulePark.setBicid(moduleBicycle.getBicid());
        List<ModuleSite> list = siteService.getSiteByNumber(siteNumber);
        ModuleSite moduleSite = list.get(0);
        modulePark.setSiteid(moduleSite.getSiteid());
        parkService.insertPark(modulePark);

        moduleSite.setSiteamount(moduleSite.getSiteamount() + 1);
        siteService.updateSite(moduleSite);

        Map<String, Object> map = new HashMap<>();
        map.put("errorLog", "right");
        return map;
    }

    @RequestMapping("/DeleteTable.do")
    public @ResponseBody Map<String, Object> deleteTable(@RequestBody ModuleBicycle[] moduleBicycle) {
        Map<String, Object> map = new HashMap<>();
        for(ModuleBicycle bicycle: moduleBicycle) {
            if(bicycle.getBicborrowed() == 0) {
                List<ModulePark> list = parkService.getParkByBicId(bicycle.getBicid());
                ModulePark modulePark = list.get(0);
                ModuleSite moduleSite = siteService.getSiteById(modulePark.getSiteid());
                moduleSite.setSiteamount(moduleSite.getSiteamount() - 1);
                siteService.updateSite(moduleSite);
                parkService.deleteParkByBicId(bicycle.getBicid());
            } else {
                rentedService.deleteRentedByBicId(bicycle.getBicid());
            }
            bicycleService.deleteBicycleById(bicycle.getBicid());
        }
        map.put("errorLog", "right");
        return map;
    }

    @RequestMapping("/EditBicycle.do")
    public @ResponseBody Map<String, Object> editBicycle(@RequestBody Map<String, Object> mapAll) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapBicycle = (Map<String, Object>) mapAll.get("bicycle");
        ModuleBicycle moduleBicycle = new ModuleBicycle();
        moduleBicycle.setBicrentprice(Float.valueOf((String) mapAll.get("bicycle.bicrentprice")));
        moduleBicycle.setBicid(Long.valueOf((Integer)mapBicycle.get("bicid")));

        System.out.println(moduleBicycle.getBicid());
        System.out.println(moduleBicycle.getBicrentprice());

        bicycleService.updateBicycle(moduleBicycle);

        map.put("errorLog", "right");
        return map;
    }
}
