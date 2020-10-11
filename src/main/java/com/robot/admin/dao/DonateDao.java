package com.robot.admin.dao;

import com.robot.admin.pojo.Donate;

import java.util.List;

/**
 * 捐赠 dao
 */
public interface DonateDao {

    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * mybatis-generator 插入一条记录
     */
    int insert(Donate record);

    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(Donate record);

    /**
     * mybatis-generator 根据id查询
     */
    Donate selectByPrimaryKey(Integer id);

    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(Donate record);

    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(Donate record);

    /**
     * 查询列表
     */
    List<Donate> findList();
}