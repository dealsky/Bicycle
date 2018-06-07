package com.bicycle.dao;

import com.bicycle.dao.entity.ModuleBicycle;
import com.bicycle.dao.entity.ModuleBicycleExample;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@Log4j
public class ModuleBicycleMapperTest {

    @Autowired
    private ModuleBicycleMapper mapper;

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
        ModuleBicycleExample example = new ModuleBicycleExample();
        ModuleBicycleExample.Criteria criteria = example.createCriteria();
        criteria.andBicborrowedEqualTo(0);

        List<ModuleBicycle> bicycleList = mapper.selectByExample(example);

        Assert.assertNotNull(bicycleList);
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}