package com.bicycle.service;

import com.bicycle.dao.entity.ModuleRentalcard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentalcardService {
    ModuleRentalcard getModuleRentalcardById(long rentalcardId);
    void insertModuleRentalcard(ModuleRentalcard moduleRentalcard);
    List<ModuleRentalcard> getModuleRentalcardByUserId(long userId);
    List<ModuleRentalcard> getModuleRentalcardByNumber(long number);
    void removeModuleRentalcardById(long rentalcardId);
    void updateModuleRentalcardSel(ModuleRentalcard moduleRentalcard);
}
