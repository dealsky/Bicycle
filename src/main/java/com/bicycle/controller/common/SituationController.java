package com.bicycle.controller.common;

import com.bicycle.dao.entity.ModuleSite;
import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.BicycleService;
import com.bicycle.service.SiteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/common")
public class SituationController {

    @Resource
    private BicycleService bicycleService;

    @Resource
    private SiteService siteService;

    @RequestMapping("/situation")
    public String situation(HttpSession session) {
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(moduleUser != null) {
            return "situation";
        } else {
            return "redirect:/user/home";
        }
    }

    @RequestMapping("/bicycleCount")
    public @ResponseBody Map<String, Integer> bicycleCount() {
        Map<String, Integer> map = bicycleService.getBicycleCount();
        return map;
    }

    @RequestMapping("/bicycleBorrowCount")
    public @ResponseBody Map<String, Integer> bicycleBorrowCount() {
        Map<String, Integer> map = bicycleService.getBicycleBorrowCount();
        return map;
    }

    @RequestMapping("/siteCount")
    public @ResponseBody Map<String, Object> siteCount() {
        Map<String, Object> map = new HashMap<>();
        List<ModuleSite> list = siteService.getSortedSite();
        long maxNumber = list.get(0).getSitenumber();
        long minNumber = list.get(list.size()-1).getSitenumber();
        map.put("siteNum", siteService.getSiteSum());
        map.put("maxNumber", maxNumber);
        map.put("minNumber", minNumber);
        return map;
    }

    @RequestMapping("/bicCount")
    public @ResponseBody Map<String, Object> bicCount() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Integer> typeMap = null;
        typeMap = bicycleService.getBicycleCount();
        Map<String, Object> maxType = new HashMap<>();
        Map<String, Object> minType = new HashMap<>();
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : typeMap.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                maxType.put("type", entry.getKey());
                maxType.put("count", entry.getValue());
            }
            if(entry.getValue() < min) {
                min = entry.getValue();
                minType.put("type", entry.getKey());
                minType.put("count", entry.getValue());
            }
        }
        map.put("bicNum", bicycleService.getBicycleSum());
        map.put("maxType", maxType);
        map.put("minType", minType);
        return map;
    }

    @RequestMapping("/borrowCount")
    public @ResponseBody Map<String, Object> borrowCount() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Integer> borrowMap = bicycleService.getBicycleBorrowCount();
        Map<String, Object> maxType = new HashMap<>();
        Map<String, Object> minType = new HashMap<>();
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        Integer borrowSum = 0;
        for(Map.Entry<String, Integer> ent : borrowMap.entrySet()) {
            if(ent.getValue() < min) {
                min = ent.getValue();
                minType.put("type", ent.getKey());
                minType.put("count", ent.getValue());
            }
            if(ent.getValue() > max) {
                max = ent.getValue();
                maxType.put("type", ent.getKey());
                maxType.put("count", ent.getValue());
            }
            borrowSum += ent.getValue();
        }
        map.put("borrowSum", borrowSum);
        map.put("maxType", maxType);
        map.put("minType", minType);
        return map;
    }

    @RequestMapping("/countSite")
    public @ResponseBody Map<String, Integer> countSite() {
        Map<String, Integer> map = siteService.getSiteCount();
        return map;
    }
}
