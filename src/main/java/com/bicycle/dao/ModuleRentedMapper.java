package com.bicycle.dao;

import com.bicycle.dao.entity.ModuleRented;
import com.bicycle.dao.entity.ModuleRentedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleRentedMapper {
    int countByExample(ModuleRentedExample example);

    int deleteByExample(ModuleRentedExample example);

    int deleteByPrimaryKey(Long rentid);

    int insert(ModuleRented record);

    int insertSelective(ModuleRented record);

    List<ModuleRented> selectByExample(ModuleRentedExample example);

    ModuleRented selectByPrimaryKey(Long rentid);

    int updateByExampleSelective(@Param("record") ModuleRented record, @Param("example") ModuleRentedExample example);

    int updateByExample(@Param("record") ModuleRented record, @Param("example") ModuleRentedExample example);

    int updateByPrimaryKeySelective(ModuleRented record);

    int updateByPrimaryKey(ModuleRented record);
}