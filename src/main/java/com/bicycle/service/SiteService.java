package com.bicycle.service;

import com.bicycle.dao.entity.ModuleSite;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SiteService {
    List<ModuleSite> getAllSite();
    List<ModuleSite> getSiteByArea(String siteArea);
    List<String> getAllSiteArea();
    PageInfo<ModuleSite> getPageSiteByArea(Integer pageNum, Integer pageSize, String siteArea);
    List<ModuleSite> getSiteByNumber(long siteNumber);
    void updateSite(ModuleSite moduleSite);
    ModuleSite getSiteById(long siteId);
    Map<String, Integer> getSiteCount();
    void insertSite(ModuleSite moduleSite);
    void deleteSiteById(long siteId);
    int getSiteSum();
    List<ModuleSite> getSortedSite();
}
