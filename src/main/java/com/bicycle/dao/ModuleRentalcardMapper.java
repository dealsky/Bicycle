package com.bicycle.dao;

import com.bicycle.dao.entity.ModuleRentalcard;
import com.bicycle.dao.entity.ModuleRentalcardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleRentalcardMapper {
    int countByExample(ModuleRentalcardExample example);

    int deleteByExample(ModuleRentalcardExample example);

    int deleteByPrimaryKey(Long recid);

    int insert(ModuleRentalcard record);

    int insertSelective(ModuleRentalcard record);

    List<ModuleRentalcard> selectByExample(ModuleRentalcardExample example);

    ModuleRentalcard selectByPrimaryKey(Long recid);

    int updateByExampleSelective(@Param("record") ModuleRentalcard record, @Param("example") ModuleRentalcardExample example);

    int updateByExample(@Param("record") ModuleRentalcard record, @Param("example") ModuleRentalcardExample example);

    int updateByPrimaryKeySelective(ModuleRentalcard record);

    int updateByPrimaryKey(ModuleRentalcard record);
}