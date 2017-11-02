package com.bicycle.service;

import com.bicycle.dao.entity.ModulePark;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkService {
    List<ModulePark> getParkBySiteId(long siteId);
    PageInfo<ModulePark> getPageParkBySiteId(long siteId, Integer pageNum, Integer pageSize);
    void deleteParkByBicId(long bicId);
}
