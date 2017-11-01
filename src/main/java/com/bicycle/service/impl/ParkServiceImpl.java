package com.bicycle.service.impl;

import com.bicycle.dao.ModuleParkMapper;
import com.bicycle.dao.entity.ModulePark;
import com.bicycle.dao.entity.ModuleParkExample;
import com.bicycle.dao.entity.ModuleSiteExample;
import com.bicycle.service.ParkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {

    @Resource
    private ModuleParkMapper moduleParkMapper;

    public List<ModulePark> getParkBySiteId(long siteId) {
        ModuleParkExample moduleParkExample = new ModuleParkExample();
        ModuleParkExample.Criteria criteria = moduleParkExample.createCriteria();
        criteria.andSiteidEqualTo(siteId);
        List<ModulePark> list = moduleParkMapper.selectByExample(moduleParkExample);
        return list;
    }

    public PageInfo<ModulePark> getPageParkBySiteId(long siteId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ModuleParkExample moduleParkExample = new ModuleParkExample();
        ModuleParkExample.Criteria criteria = moduleParkExample.createCriteria();
        criteria.andSiteidEqualTo(siteId);
        List<ModulePark> list = moduleParkMapper.selectByExample(moduleParkExample);
        if(list == null) {
            return null;
        } else {
            PageInfo<ModulePark> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
    }
}
