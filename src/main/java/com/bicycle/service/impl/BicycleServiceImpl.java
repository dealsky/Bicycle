package com.bicycle.service.impl;

import com.bicycle.dao.ModuleBicycleMapper;
import com.bicycle.dao.entity.ModuleBicycle;
import com.bicycle.dao.entity.ModuleBicycleExample;
import com.bicycle.service.BicycleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void updateBicycle(ModuleBicycle moduleBicycle) {
        moduleBicycleMapper.updateByPrimaryKeySelective(moduleBicycle);
    }

    public List<String> getBicycleType() {
        ModuleBicycleExample moduleBicycleExample = new ModuleBicycleExample();
        List<ModuleBicycle> list = moduleBicycleMapper.selectByExample(moduleBicycleExample);
        List<String> typeList = new ArrayList<>();
        typeList.add(list.get(0).getBictype());
        for(int i = 1; i<list.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < typeList.size(); j++) {
                if (list.get(i).getBictype().equals(typeList.get(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                typeList.add(list.get(i).getBictype());
            }
        }
        return typeList;
    }

    public Map<String, Integer> getBicycleCount() {
        Map<String, Integer> map = new HashMap<>();
        List<String> typeList = getBicycleType();
        for(int i = 0; i<typeList.size(); i++) {
            ModuleBicycleExample moduleBicycleExample = new ModuleBicycleExample();
            ModuleBicycleExample.Criteria criteria = moduleBicycleExample.createCriteria();
            criteria.andBictypeEqualTo(typeList.get(i));
            Integer count = moduleBicycleMapper.countByExample(moduleBicycleExample);
            map.put(typeList.get(i), count);
        }
        return map;
    }

    public Map<String, Integer> getBicycleBorrowCount() {
        Map<String, Integer> map = new HashMap<>();
        List<String> typeList = getBicycleType();
        for(int i = 0; i<typeList.size(); i++) {
            ModuleBicycleExample moduleBicycleExample = new ModuleBicycleExample();
            ModuleBicycleExample.Criteria criteria = moduleBicycleExample.createCriteria();
            criteria.andBictypeEqualTo(typeList.get(i));
            List<ModuleBicycle> list = moduleBicycleMapper.selectByExample(moduleBicycleExample);
            Integer count = 0;
            for(int j = 0; j<list.size(); j++) {
                count += list.get(j).getBicborrowedcount();
            }
            map.put(typeList.get(i), count);
        }
        return map;
    }

    public void insertBicycle(ModuleBicycle moduleBicycle) {
        moduleBicycleMapper.insert(moduleBicycle);
    }

    public void deleteBicycleById(long bicId) {
        moduleBicycleMapper.deleteByPrimaryKey(bicId);
    }

    public int getBicycleSum() {
        ModuleBicycleExample moduleBicycleExample = new ModuleBicycleExample();
        int sum = 0;
        sum = moduleBicycleMapper.countByExample(moduleBicycleExample);
        return sum;
    }
}
