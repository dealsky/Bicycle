package com.bicycle.controller.user;

import com.bicycle.dao.entity.ModuleRentalcard;
import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.RentalcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/User")
public class RentalcardController {

    @Resource
    private RentalcardService rentalcardService;

    @RequestMapping("/RentalCard")
    public String rentalCard(HttpSession session) {
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        if(moduleUser == null) {
            return "redirect:Home";
        } else {
            long userId = moduleUser.getUserid();
            List<ModuleRentalcard> list = rentalcardService.getModuleRentalcardByUserId(userId);
            session.setAttribute("cards", list);
            return "rentalcard";
        }
    }

    @RequestMapping("/addRentCard.do")
    public @ResponseBody Map<String, Object> addRentCard(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        ModuleUser moduleUser = (ModuleUser) session.getAttribute("user");
        ModuleRentalcard moduleRentalcard = new ModuleRentalcard();
        if(moduleUser != null) {
            moduleRentalcard.setUserid(moduleUser.getUserid());
            List<ModuleRentalcard> list = rentalcardService.getModuleRentalcardByUserId(moduleUser.getUserid());
            if(list.size() == 0) {
                Random random = new Random();
                long recNumber = recNumber = 7400000000L + moduleUser.getUserid()*100 + random.nextInt(99);
                moduleRentalcard.setRecnumber(recNumber);
                moduleRentalcard.setRecbalance(0f);
                moduleRentalcard.setRecstatus(0);
                rentalcardService.insertModuleRentalcard(moduleRentalcard);
                map.put("message", "right");
            } else {
                map.put("message", "error");
            }
        } else {
            map.put("message", "null");
        }
        return map;
    }

    @RequestMapping("/removeRentCard.do")
    public String removeRentCard(HttpSession session, @RequestParam long recId) {
        List<ModuleRentalcard> list = (List<ModuleRentalcard>) session.getAttribute("cards");
        rentalcardService.removeModuleRentalcardById(recId);
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i).getRecid() == recId) {
                list.remove(i);
            }
        }
        session.setAttribute("cards", list);
        return "redirect:RentalCard";
    }

    @RequestMapping("/chargeMoney.do")
    public String chargeMoney(HttpSession session, @RequestParam long recId, @RequestParam float recCharge) {
        List<ModuleRentalcard> list = (List<ModuleRentalcard>) session.getAttribute("cards");
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i).getRecid() == recId) {
                ModuleRentalcard moduleRentalcard = new ModuleRentalcard();
                moduleRentalcard.setRecid(recId);
                float recBalance = list.get(i).getRecbalance();
                recBalance += recCharge;
                moduleRentalcard.setRecbalance(recBalance);
                rentalcardService.updateModuleRentalcardSel(moduleRentalcard);
                list.get(i).setRecbalance(recBalance);
                break;
            }
        }
        session.setAttribute("cards", list);
        return "redirect:RentalCard";
    }
}
