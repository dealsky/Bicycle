package com.bicycle.service;

import com.bicycle.dao.entity.ModuleBicycle;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BicycleService {
    List<ModuleBicycle> getAllBicycle();
    PageInfo<ModuleBicycle> getPageBicycle(Integer pageNum, Integer pageSize);
    ModuleBicycle getBicycleById(long bicycleId);
    List<ModuleBicycle> getBicycleByNumber(long bicycleNumber);
    void updateBicycle(ModuleBicycle moduleBicycle);
    Map<String, Integer> getBicycleCount();
    Map<String, Integer> getBicycleBorrowCount();
    List<String> getBicycleType();
    void insertBicycle(ModuleBicycle moduleBicycle);
    void deleteBicycleById(long bicId);
    int getBicycleSum();
}
