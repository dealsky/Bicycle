package com.bicycle.service;

import com.bicycle.dao.entity.ModuleRented;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentedService {
    void insertRented(ModuleRented moduleRented);
    List<ModuleRented> getRentedByUserId(long userId);
    void deleteRentedByBicId(long bicId);
    List<ModuleRented> getRentedByBicId(long bicId);
}
