package com.bicycle.controller;

import com.bicycle.dao.entity.*;
import com.bicycle.service.BicycleService;
import com.bicycle.service.ParkService;
import com.bicycle.service.RentalcardService;
import com.bicycle.service.SiteService;
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

    /*
    @RequestMapping("/Borrow")
    public String borrow(HttpSession session, HttpServletRequest request) {
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(moduleUser == null) {
            return "redirect:Home";
        } else {
            long userId = moduleUser.getUserid();
            List<ModuleRentalcard> list = rentalcardService.getModuleRentalcardByUserId(userId);
            session.setAttribute("cards", list);

            List<ModuleSite> list1 = siteService.getAllSite();
            session.setAttribute("sites", list1);

            Integer pageNum = request.getParameter("pageNum") == null ? 2 : Integer.valueOf(request.getParameter("pageNum"));

            System.out.println(pageNum);

            PageInfo<ModuleBicycle> pageInfo = bicycleService.getPageBicycle(pageNum, 10);
            List<ModuleBicycle> list2 = pageInfo.getList();
            long pageSize = 0;
            if(pageInfo.getTotal()%10 == 0) {
                pageSize = pageInfo.getTotal() / 10;
            } else {
                pageSize = pageInfo.getTotal() / 10 + 1;
            }
            Map<String, Object> map = new HashMap<>();
            map.put("pageList", list2);
            map.put("pageSize", pageSize);
            session.setAttribute("bicycles", map);
            return "borrowbicycle";
        }
    }*/

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
}
