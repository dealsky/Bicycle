package com.bicycle.dao;

import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.dao.entity.ModuleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleUserMapper {
    int countByExample(ModuleUserExample example);

    int deleteByExample(ModuleUserExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(ModuleUser record);

    int insertSelective(ModuleUser record);

    List<ModuleUser> selectByExample(ModuleUserExample example);

    ModuleUser selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") ModuleUser record, @Param("example") ModuleUserExample example);

    int updateByExample(@Param("record") ModuleUser record, @Param("example") ModuleUserExample example);

    int updateByPrimaryKeySelective(ModuleUser record);

    int updateByPrimaryKey(ModuleUser record);
}