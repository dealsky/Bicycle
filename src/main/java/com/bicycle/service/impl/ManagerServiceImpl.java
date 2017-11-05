package com.bicycle.service.impl;

import com.bicycle.dao.ModuleManagerMapper;
import com.bicycle.dao.ModuleSiteMapper;
import com.bicycle.dao.entity.ModuleManager;
import com.bicycle.dao.entity.ModuleManagerExample;
import com.bicycle.dao.entity.ModuleSite;
import com.bicycle.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Resource
    private ModuleManagerMapper moduleManagerMapper;

    public List<ModuleManager> getManagerByAcc(String managerAcc) {
        ModuleManagerExample moduleManagerExample = new ModuleManagerExample();
        ModuleManagerExample.Criteria criteria = moduleManagerExample.createCriteria();
        criteria.andMagaccountEqualTo(managerAcc);
        List<ModuleManager> list = moduleManagerMapper.selectByExample(moduleManagerExample);
        return list;
    }

    public void updateManager(ModuleManager moduleManager) {
        moduleManagerMapper.updateByPrimaryKeySelective(moduleManager);
    }

}
