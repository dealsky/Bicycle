package com.bicycle.service.impl;

import com.bicycle.dao.ModuleRentedMapper;
import com.bicycle.dao.entity.ModuleRentalcardExample;
import com.bicycle.dao.entity.ModuleRented;
import com.bicycle.dao.entity.ModuleRentedExample;
import com.bicycle.service.RentedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RentedServiceImpl implements RentedService{

    @Resource
    private ModuleRentedMapper moduleRentedMapper;

    public void insertRented(ModuleRented moduleRented) {
        moduleRentedMapper.insert(moduleRented);
    }

    public List<ModuleRented> getRentedByUserId(long userId) {
        ModuleRentedExample moduleRentedExample = new ModuleRentedExample();
        ModuleRentedExample.Criteria criteria = moduleRentedExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<ModuleRented> list = moduleRentedMapper.selectByExample(moduleRentedExample);
        return list;
    }

    public void deleteRentedByBicId(long bicId) {
        ModuleRentedExample moduleRentedExample = new ModuleRentedExample();
        ModuleRentedExample.Criteria criteria = moduleRentedExample.createCriteria();
        criteria.andBicidEqualTo(bicId);
        moduleRentedMapper.deleteByExample(moduleRentedExample);
    }
}
