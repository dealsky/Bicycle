package com.bicycle.controller;

import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.BicycleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SituationController {

    @Resource
    private BicycleService bicycleService;

    @RequestMapping("/Situation")
    public String situation(HttpSession session) {
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(moduleUser != null) {
            return "situation";
        } else {
            return "redirect:Home";
        }
    }

    @RequestMapping("/BicycleCount.do")
    public @ResponseBody Map<String, Integer> bicycleCount() {
        Map<String, Integer> map = bicycleService.getBicycleCount();
        return map;
    }

    @RequestMapping("/BicycleBorrowCount.do")
    public @ResponseBody Map<String, Integer> bicycleBorrowCount() {
        Map<String, Integer> map = bicycleService.getBicycleBorrowCount();
        return map;
    }
}
