package com.bicycle.dao;

import com.bicycle.dao.entity.ModuleSite;
import com.bicycle.dao.entity.ModuleSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleSiteMapper {
    int countByExample(ModuleSiteExample example);

    int deleteByExample(ModuleSiteExample example);

    int deleteByPrimaryKey(Long siteid);

    int insert(ModuleSite record);

    int insertSelective(ModuleSite record);

    List<ModuleSite> selectByExample(ModuleSiteExample example);

    ModuleSite selectByPrimaryKey(Long siteid);

    int updateByExampleSelective(@Param("record") ModuleSite record, @Param("example") ModuleSiteExample example);

    int updateByExample(@Param("record") ModuleSite record, @Param("example") ModuleSiteExample example);

    int updateByPrimaryKeySelective(ModuleSite record);

    int updateByPrimaryKey(ModuleSite record);
}