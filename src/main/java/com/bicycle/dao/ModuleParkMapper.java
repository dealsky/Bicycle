package com.bicycle.dao;

import com.bicycle.dao.entity.ModulePark;
import com.bicycle.dao.entity.ModuleParkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleParkMapper {
    int countByExample(ModuleParkExample example);

    int deleteByExample(ModuleParkExample example);

    int deleteByPrimaryKey(Long parkid);

    int insert(ModulePark record);

    int insertSelective(ModulePark record);

    List<ModulePark> selectByExample(ModuleParkExample example);

    ModulePark selectByPrimaryKey(Long parkid);

    int updateByExampleSelective(@Param("record") ModulePark record, @Param("example") ModuleParkExample example);

    int updateByExample(@Param("record") ModulePark record, @Param("example") ModuleParkExample example);

    int updateByPrimaryKeySelective(ModulePark record);

    int updateByPrimaryKey(ModulePark record);
}