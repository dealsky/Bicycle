package com.bicycle.controller;

import com.bicycle.dao.entity.*;
import com.bicycle.service.*;
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
public class ReturnBicycleController {

    @Resource
    private RentedService rentedService;

    @Resource
    private BicycleService bicycleService;

    @Resource
    private SiteService siteService;

    @Resource
    private ParkService parkService;

    @Resource
    private RentalcardService rentalcardService;

    @RequestMapping("/DisplayRented.do")
    public @ResponseBody Map<String, Object> displayRented(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(moduleUser != null) {
            List<ModuleRented> list = rentedService.getRentedByUserId(moduleUser.getUserid());
            if(list.size() != 0) {
                ModuleRented moduleRented = list.get(0);
                ModuleBicycle moduleBicycle = bicycleService.getBicycleById(moduleRented.getBicid());
                map.put("errorLog", "right");
                map.put("bicycle", moduleBicycle);
                Date rentTime = moduleRented.getRenttime();
                map.put("rentTime", rentTime);
            } else {
                map.put("errorLog", "noRented");
            }
        } else {
            map.put("errorLog", "login");
        }
        return map;
    }

    @RequestMapping("/ReturnBicycle.do")
    public @ResponseBody Map<String, Object> returnBicycle(@RequestParam long bicId, @RequestParam long siteNumber,
                                                           @RequestParam float price, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        List<ModuleSite> list = siteService.getSiteByNumber(siteNumber);
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(list.size() != 0) {
            ModuleSite moduleSite = list.get(0);

            //  insert park
            ModulePark modulePark = new ModulePark();
            modulePark.setSiteid(moduleSite.getSiteid());
            modulePark.setBicid(bicId);
            parkService.insertPark(modulePark);

            //  update site
            ModuleSite moduleSiteNew = new ModuleSite();
            moduleSiteNew.setSiteid(moduleSite.getSiteid());
            moduleSiteNew.setSiteamount(moduleSite.getSiteamount() + 1);
            siteService.updateSite(moduleSiteNew);

            //  update bicycle
            ModuleBicycle moduleBicycleNew = new ModuleBicycle();
            moduleBicycleNew.setBicid(bicId);
            moduleBicycleNew.setBicborrowed(0);
            bicycleService.updateBicycle(moduleBicycleNew);

            //  update rentalCard
            List<ModuleRentalcard> list1 = rentalcardService.getModuleRentalcardByUserId(moduleUser.getUserid());
            ModuleRentalcard moduleRentalcard = list1.get(0);
            ModuleRentalcard moduleRentalcardNew = new ModuleRentalcard();
            moduleRentalcardNew.setRecid(moduleRentalcard.getRecid());
            moduleRentalcardNew.setRecbalance(moduleRentalcard.getRecbalance() - price);
            rentalcardService.updateModuleRentalcardSel(moduleRentalcardNew);

            //  delete  rented
            rentedService.deleteRentedByBicId(bicId);

            map.put("errorLog", "right");
        } else {
            map.put("errorLog", "noSite");
        }
        return map;
    }
}
