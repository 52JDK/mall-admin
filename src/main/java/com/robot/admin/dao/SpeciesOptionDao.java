package com.robot.admin.dao;

import com.robot.admin.pojo.SpeciesOption;

import java.util.List;

/**
 * 品牌属性dao
 */
public interface SpeciesOptionDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(SpeciesOption record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(SpeciesOption record);
    /**
     * mybatis-generator 根据id查询
     */
    SpeciesOption selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(SpeciesOption record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(SpeciesOption record);

    /**
     * 查询列表
     */
    List<SpeciesOption>  findSpecies();
}