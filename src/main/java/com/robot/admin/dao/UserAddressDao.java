package com.robot.admin.dao;

import com.robot.admin.pojo.UserAddress;

/**
 * 用户地址
 */
public interface UserAddressDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(UserAddress record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(UserAddress record);
    /**
     * mybatis-generator 根据id查询
     */
    UserAddress selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新一条记录
     */
    int updateByPrimaryKeySelective(UserAddress record);
    /**
     * mybatis-generator 更新一条记录 空字段不会写入
     */
    int updateByPrimaryKey(UserAddress record);
}