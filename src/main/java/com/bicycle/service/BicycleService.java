package com.bicycle.service;

import com.bicycle.dao.entity.ModuleBicycle;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BicycleService {
    List<ModuleBicycle> getAllBicycle();
    PageInfo<ModuleBicycle> getPageBicycle(Integer pageNum, Integer pageSize);
    ModuleBicycle getBicycleById(long bicycleId);
}
