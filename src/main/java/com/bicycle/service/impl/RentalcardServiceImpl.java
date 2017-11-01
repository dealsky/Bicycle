package com.bicycle.service.impl;

import com.bicycle.dao.ModuleRentalcardMapper;
import com.bicycle.dao.entity.ModuleRentalcard;
import com.bicycle.dao.entity.ModuleRentalcardExample;
import com.bicycle.service.RentalcardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RentalcardServiceImpl implements RentalcardService {

    @Resource
    private ModuleRentalcardMapper moduleRentalcardMapper;

    public ModuleRentalcard getModuleRentalcardById(long rentalcardId) {
        ModuleRentalcard moduleRentalcard = moduleRentalcardMapper.selectByPrimaryKey(rentalcardId);
        return moduleRentalcard;
    }

    public void insertModuleRentalcard(ModuleRentalcard moduleRentalcard) {
        moduleRentalcardMapper.insert(moduleRentalcard);
    }

    public List<ModuleRentalcard> getModuleRentalcardByUserId(long userId) {
        ModuleRentalcardExample moduleRentalcardExample = new ModuleRentalcardExample();
        ModuleRentalcardExample.Criteria criteria = moduleRentalcardExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<ModuleRentalcard> list = moduleRentalcardMapper.selectByExample(moduleRentalcardExample);
        return list;
    }

    public List<ModuleRentalcard> getModuleRentalcardByNumber(long number) {
        ModuleRentalcardExample moduleRentalcardExample = new ModuleRentalcardExample();
        ModuleRentalcardExample.Criteria criteria = moduleRentalcardExample.createCriteria();
        criteria.andRecnumberEqualTo(number);
        List<ModuleRentalcard> list = moduleRentalcardMapper.selectByExample(moduleRentalcardExample);
        return list;
    }

    public void removeModuleRentalcardById(long rentalcardId) {
        moduleRentalcardMapper.deleteByPrimaryKey(rentalcardId);
    }

    public void updateModuleRentalcardSel(ModuleRentalcard moduleRentalcard) {
        moduleRentalcardMapper.updateByPrimaryKeySelective(moduleRentalcard);
    }
}
