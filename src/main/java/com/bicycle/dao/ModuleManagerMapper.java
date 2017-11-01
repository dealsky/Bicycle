package com.bicycle.dao;

import com.bicycle.dao.entity.ModuleManager;
import com.bicycle.dao.entity.ModuleManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleManagerMapper {
    int countByExample(ModuleManagerExample example);

    int deleteByExample(ModuleManagerExample example);

    int deleteByPrimaryKey(Long magid);

    int insert(ModuleManager record);

    int insertSelective(ModuleManager record);

    List<ModuleManager> selectByExample(ModuleManagerExample example);

    ModuleManager selectByPrimaryKey(Long magid);

    int updateByExampleSelective(@Param("record") ModuleManager record, @Param("example") ModuleManagerExample example);

    int updateByExample(@Param("record") ModuleManager record, @Param("example") ModuleManagerExample example);

    int updateByPrimaryKeySelective(ModuleManager record);

    int updateByPrimaryKey(ModuleManager record);
}