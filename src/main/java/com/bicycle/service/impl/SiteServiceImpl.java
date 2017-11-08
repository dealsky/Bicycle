package com.bicycle.service.impl;

import com.bicycle.dao.ModuleSiteMapper;
import com.bicycle.dao.entity.ModuleSite;
import com.bicycle.dao.entity.ModuleSiteExample;
import com.bicycle.service.SiteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SiteServiceImpl implements SiteService {

    @Resource
    private ModuleSiteMapper moduleSiteMapper;

    public List<ModuleSite> getAllSite() {
        ModuleSiteExample moduleSiteExample = new ModuleSiteExample();
        List<ModuleSite> list = moduleSiteMapper.selectByExample(moduleSiteExample);
        return list;
    }

    public List<ModuleSite> getSiteByArea(String siteArea) {
        ModuleSiteExample moduleSiteExample = new ModuleSiteExample();
        ModuleSiteExample.Criteria criteria = moduleSiteExample.createCriteria();
        criteria.andSiteareaEqualTo(siteArea);
        List<ModuleSite> list = moduleSiteMapper.selectByExample(moduleSiteExample);
        return list;
    }

    public List<String> getAllSiteArea() {
        ModuleSiteExample moduleSiteExample = new ModuleSiteExample();
        moduleSiteExample.setDistinct(false);
        List<ModuleSite> list = moduleSiteMapper.selectByExample(moduleSiteExample);
        List<String> listArea = new ArrayList<>();
        for(int i = 0; i<list.size(); i++) {
            boolean flag = true;
            for(int j = 0; j<listArea.size(); j++) {
                if(listArea.get(j).equals(list.get(i).getSitearea())) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                listArea.add(list.get(i).getSitearea());
            }
        }
        return listArea;
    }

    public PageInfo<ModuleSite> getPageSiteByArea(Integer pageNum, Integer pageSize, String siteArea) {
        PageHelper.startPage(pageNum, pageSize);
        ModuleSiteExample moduleSiteExample = new ModuleSiteExample();
        ModuleSiteExample.Criteria criteria = moduleSiteExample.createCriteria();
        criteria.andSiteareaEqualTo(siteArea);
        List<ModuleSite> list = moduleSiteMapper.selectByExample(moduleSiteExample);
        if(list == null) {
            return null;
        } else {
            PageInfo<ModuleSite> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
    }

    public List<ModuleSite> getSiteByNumber(long siteNumber) {
        ModuleSiteExample moduleSiteExample = new ModuleSiteExample();
        ModuleSiteExample.Criteria criteria = moduleSiteExample.createCriteria();
        criteria.andSitenumberEqualTo(siteNumber);
        List<ModuleSite> list = moduleSiteMapper.selectByExample(moduleSiteExample);
        return list;
    }

    public void updateSite(ModuleSite moduleSite) {
        moduleSiteMapper.updateByPrimaryKeySelective(moduleSite);
    }

    public ModuleSite getSiteById(long siteId) {
        ModuleSite moduleSite = moduleSiteMapper.selectByPrimaryKey(siteId);
        return moduleSite;
    }

    public Map<String, Integer> getSiteCount() {
        Map<String, Integer> map = new HashMap<>();
        List<ModuleSite> list = getAllSite();
        for(int i = 0; i<list.size(); i++) {
            map.put(String.valueOf(list.get(i).getSitenumber()), list.get(i).getSiteamount());
        }
        return map;
    }

    public void insertSite(ModuleSite moduleSite) {
        moduleSiteMapper.insert(moduleSite);
    }

    public void deleteSiteById(long siteId) {
        moduleSiteMapper.deleteByPrimaryKey(siteId);
    }
}
