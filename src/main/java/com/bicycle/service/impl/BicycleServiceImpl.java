package com.bicycle.service.impl;

import com.bicycle.dao.ModuleBicycleMapper;
import com.bicycle.dao.entity.ModuleBicycle;
import com.bicycle.dao.entity.ModuleBicycleExample;
import com.bicycle.service.BicycleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BicycleServiceImpl implements BicycleService {

    @Resource
    private ModuleBicycleMapper moduleBicycleMapper;

    public List<ModuleBicycle> getAllBicycle() {
        ModuleBicycleExample moduleBicycleExample = new ModuleBicycleExample();
        List<ModuleBicycle> list = moduleBicycleMapper.selectByExample(moduleBicycleExample);
        return list;
    }

    public PageInfo<ModuleBicycle> getPageBicycle(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ModuleBicycleExample moduleBicycleExample = new ModuleBicycleExample();
        List<ModuleBicycle> list = moduleBicycleMapper.selectByExample(moduleBicycleExample);
        if(list == null) {
            return null;
        } else {
            PageInfo<ModuleBicycle> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
    }

    public ModuleBicycle getBicycleById(long bicycleId) {
        ModuleBicycle moduleBicycle = moduleBicycleMapper.selectByPrimaryKey(bicycleId);
        return moduleBicycle;
    }

    public List<ModuleBicycle> getBicycleByNumber(long bicycleNumber) {
        ModuleBicycleExample moduleBicycleExample = new ModuleBicycleExample();
        ModuleBicycleExample.Criteria criteria = moduleBicycleExample.createCriteria();
        criteria.andBicnumberEqualTo(bicycleNumber);
        List<ModuleBicycle> list = moduleBicycleMapper.selectByExample(moduleBicycleExample);
        return list;
    }
}
