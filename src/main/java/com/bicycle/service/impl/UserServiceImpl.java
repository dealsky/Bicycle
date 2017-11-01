package com.bicycle.service.impl;

import com.bicycle.dao.ModuleUserMapper;
import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.dao.entity.ModuleUserExample;
import com.bicycle.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private ModuleUserMapper moduleUserMapper;

    public ModuleUser getModuleUserById(long userId) {
        ModuleUser moduleUser = moduleUserMapper.selectByPrimaryKey(userId);
        return moduleUser;
    }

    public Map<String, Object> isModuleReg(String userAcc, String userPass) {
        Map<String, Object> map = new HashMap<>();
        ModuleUserExample moduleUserExample = new ModuleUserExample();
        ModuleUserExample.Criteria criteria = moduleUserExample.createCriteria();
        criteria.andUseraccEqualTo(userAcc);
        List<ModuleUser> moduleUserList = moduleUserMapper.selectByExample(moduleUserExample);
        if(moduleUserList.size() == 0) {
            map.put("status", "null");
        } else if(!moduleUserList.get(0).getUserpass().equals(userPass)) {
            map.put("status", "passError");
        } else {
            map.put("status", "right");
        }
        return map;
    }
    public List<ModuleUser> getModuleUserByAcc(String userAcc){
        ModuleUserExample moduleUserExample = new ModuleUserExample();
        ModuleUserExample.Criteria criteria = moduleUserExample.createCriteria();
        criteria.andUseraccEqualTo(userAcc);
        List<ModuleUser> list = moduleUserMapper.selectByExample(moduleUserExample);
        return list;
    }

    public void updateUserLastLoginTimeByAcc(long userId) {
        ModuleUser moduleUser = new ModuleUser();
        Date date = new Date();
        moduleUser.setUserlastlogintime(date);
        moduleUser.setUserid(userId);
        moduleUserMapper.updateByPrimaryKeySelective(moduleUser);
    }

    public List<ModuleUser> getModuleUserByEmail(String userEmail) {
        ModuleUserExample moduleUserExample = new ModuleUserExample();
        ModuleUserExample.Criteria criteria = moduleUserExample.createCriteria();
        criteria.andUseremailEqualTo(userEmail);
        List<ModuleUser> list = moduleUserMapper.selectByExample(moduleUserExample);
        return list;
    }

    public void insertModuleUser(ModuleUser moduleUser) {
        moduleUserMapper.insert(moduleUser);
    }

    public void updateUserEmail(String userEmail, long userId) {
        ModuleUser moduleUser = new ModuleUser();
        moduleUser.setUseremail(userEmail);
        moduleUser.setUserid(userId);
        moduleUserMapper.updateByPrimaryKeySelective(moduleUser);
    }

    public void updateUserInfo(ModuleUser moduleUser) {
        moduleUserMapper.updateByPrimaryKeySelective(moduleUser);
    }

    public boolean panUserPass(ModuleUser moduleUser, String userPass) {
        if(moduleUser.getUserpass().equals(userPass)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateUserPass(long userId, String userPass) {
        ModuleUser moduleUser = new ModuleUser();
        moduleUser.setUserpass(userPass);
        moduleUser.setUserid(userId);
        moduleUserMapper.updateByPrimaryKeySelective(moduleUser);
    }
}
