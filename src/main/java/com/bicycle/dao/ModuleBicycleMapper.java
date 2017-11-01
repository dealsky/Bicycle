package com.bicycle.dao;

import com.bicycle.dao.entity.ModuleBicycle;
import com.bicycle.dao.entity.ModuleBicycleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleBicycleMapper {
    int countByExample(ModuleBicycleExample example);

    int deleteByExample(ModuleBicycleExample example);

    int deleteByPrimaryKey(Long bicid);

    int insert(ModuleBicycle record);

    int insertSelective(ModuleBicycle record);

    List<ModuleBicycle> selectByExample(ModuleBicycleExample example);

    ModuleBicycle selectByPrimaryKey(Long bicid);

    int updateByExampleSelective(@Param("record") ModuleBicycle record, @Param("example") ModuleBicycleExample example);

    int updateByExample(@Param("record") ModuleBicycle record, @Param("example") ModuleBicycleExample example);

    int updateByPrimaryKeySelective(ModuleBicycle record);

    int updateByPrimaryKey(ModuleBicycle record);
}