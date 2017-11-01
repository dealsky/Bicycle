package com.bicycle.service;

import com.bicycle.dao.entity.ModuleUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    ModuleUser getModuleUserById(long userId);
    Map<String, Object> isModuleReg(String userAcc, String userPass);
    List getModuleUserByAcc(String userAcc);
    void updateUserLastLoginTimeByAcc(long userId);
    List getModuleUserByEmail(String userEmail);
    void insertModuleUser(ModuleUser moduleUser);
    void updateUserEmail(String userEmail, long userId);
    void updateUserInfo(ModuleUser moduleUser);
    boolean panUserPass(ModuleUser moduleUser, String userPass);
    void updateUserPass(long userId, String userPass);
}
