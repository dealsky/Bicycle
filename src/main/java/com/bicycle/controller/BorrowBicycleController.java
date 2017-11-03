package com.bicycle.controller;

import com.bicycle.dao.entity.*;
import com.bicycle.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BorrowBicycleController {

    @Resource
    private RentalcardService rentalcardService;
    @Resource
    private SiteService siteService;
    @Resource
    private BicycleService bicycleService;
    @Resource
    private ParkService parkService;
    @Resource
    private RentedService rentedService;

    @RequestMapping("/Borrow")
    public String borrow(HttpSession session) {
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(moduleUser == null) {
            return "redirect:Home";
        } else {
            return "borrowbicycle";
        }
    }

    @RequestMapping("/GetArea.do")
    public @ResponseBody Map<String, Object> getArea() {
        Map<String, Object> map = new HashMap<>();
        List<String> list = siteService.getAllSiteArea();
        map.put("sites", list);
        return map;
    }

    @RequestMapping("/DisplaySite.do")
    public @ResponseBody Map<String, Object> displaySite(@RequestParam String siteArea, @RequestParam Integer pageNum) {
        Map<String, Object> map = new HashMap<>();
        int pageSize = 5;
        PageInfo<ModuleSite> pageInfo = siteService.getPageSiteByArea(pageNum, pageSize, siteArea);
        List<ModuleSite> list = pageInfo.getList();
        long pageLen = 1;
        if(pageInfo.getTotal()%pageSize == 0) {
            pageLen = pageInfo.getTotal() / pageSize;
        } else {
            pageLen = pageInfo.getTotal() / pageSize + 1;
        }
        map.put("sites", list);
        map.put("pageLen", pageLen);
        return map;
    }

    @RequestMapping("/SearchSite.do")
    public @ResponseBody Map<String, Object> searchSite(@RequestParam long siteNumber) {
        Map<String, Object> map = new HashMap<>();
        List<ModuleSite> list = siteService.getSiteByNumber(siteNumber);
        if(list.size() == 0) {
            map.put("message", "error");
        } else {
            map.put("message", "right");
            map.put("site", list.get(0));
        }
        return map;
    }

    @RequestMapping("/DisplayBicycle.do")
    public @ResponseBody Map<String, Object> displayBicycle(@RequestParam long siteId, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<ModulePark> pageInfo = parkService.getPageParkBySiteId(siteId, pageNum, pageSize);
        List<ModulePark> list = pageInfo.getList();
        long pageLen = pageInfo.getTotal();
        if(pageLen == 0) {
            map.put("message", "error");
        } else {
            if(pageLen % pageSize == 0) {
                pageLen = pageLen / pageSize;
            } else {
                pageLen = pageLen / pageSize +1;
            }
            map.put("message", "right");
            map.put("pageLen", pageLen);

            List<ModuleBicycle> listBicycle = new ArrayList<>();

            for(int i = 0; i<list.size(); i++) {
                ModuleBicycle moduleBicycle = bicycleService.getBicycleById(list.get(i).getBicid());
                listBicycle.add(moduleBicycle);
            }
            map.put("bicycles", listBicycle);
        }
        return map;
    }

    @RequestMapping("/SearchBicycle.do")
    public @ResponseBody Map<String, Object> searchBicycle(@RequestParam long bicycleNumber) {
        Map<String, Object> map = new HashMap<>();
        List<ModuleBicycle> list = bicycleService.getBicycleByNumber(bicycleNumber);
        if(list.size() == 0) {
            map.put("message", "error");
        } else {
            map.put("message", "right");
            map.put("bicycle", list.get(0));
        }
        return map;
    }

    @RequestMapping("/JudgmentBorrow.do")
    public @ResponseBody Map<String, Object> judgmentBorrow(@RequestParam long bicycleNumber, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(moduleUser != null) {
            List<ModuleBicycle> list = bicycleService.getBicycleByNumber(bicycleNumber);
            ModuleBicycle moduleBicycle = list.get(0);
            List<ModuleRentalcard> list1 = rentalcardService.getModuleRentalcardByUserId(moduleUser.getUserid());
            List<ModuleRented> list2 = rentedService.getRentedByUserId(moduleUser.getUserid());
            if(list2.size() == 0) {
                if(list1.size() != 0) {
                    ModuleRentalcard moduleRentalcard = list1.get(0);
                    if(moduleRentalcard.getRecbalance() >= moduleBicycle.getBicrentprice()) {
                        map.put("errorLog", "null");

                        //  update Bicycle
                        ModuleBicycle moduleBicycleNew = new ModuleBicycle();
                        moduleBicycleNew.setBicid(moduleBicycle.getBicid());
                        moduleBicycleNew.setBicborrowed(1);
                        moduleBicycleNew.setBicborrowedcount(moduleBicycle.getBicborrowedcount() + 1);
                        bicycleService.updateBicycle(moduleBicycleNew);

                        //  update Site
                        ModulePark modulePark = parkService.getParkByBicId(moduleBicycle.getBicid()).get(0);
                        ModuleSite moduleSite = siteService.getSiteById(modulePark.getSiteid());
                        ModuleSite moduleSiteNew = new ModuleSite();
                        moduleSiteNew.setSiteid(moduleSite.getSiteid());
                        moduleSiteNew.setSiteamount(moduleSite.getSiteamount() - 1);
                        siteService.updateSite(moduleSiteNew);

                        //  delete park
                        parkService.deleteParkByBicId(moduleBicycle.getBicid());

                        //  insert Rented
                        ModuleRented moduleRented = new ModuleRented();
                        moduleRented.setUserid(moduleUser.getUserid());
                        moduleRented.setBicid(moduleBicycle.getBicid());
                        rentedService.insertRented(moduleRented);

                    } else {
                        map.put("errorLog", "money");
                    }
                } else {
                    map.put("errorLog", "card");
                }
            } else {
                map.put("errorLog", "two");
            }
        } else {
            map.put("errorLog", "login");
        }
        return map;
    }
}
