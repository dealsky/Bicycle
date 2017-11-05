package com.bicycle.service;

import com.bicycle.dao.entity.ModuleManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ManagerService {
    List<ModuleManager> getManagerByAcc(String managerAcc);
    void updateManager(ModuleManager moduleManager);
}
