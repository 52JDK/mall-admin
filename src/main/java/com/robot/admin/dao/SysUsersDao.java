package com.robot.admin.dao;

import com.alibaba.fastjson.JSONObject;
import com.robot.admin.pojo.SysUsers;

import java.util.List;

/**
 * 用户dao
 */
public interface SysUsersDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Long id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(SysUsers record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(SysUsers record);
    /**
     * mybatis-generator 根据id查询
     */
    SysUsers selectUserRole(String userName);
    /**
     * mybatis-generator 更新一条记录
     */
    int updateByPrimaryKeySelective(SysUsers record);
    /**
     * mybatis-generator 更新一条记录 空字段不会写入
     */
    int updateByPrimaryKey(SysUsers record);

    /**
     * 根据用户名查询
     */
    SysUsers findUserByName(String userName);

    /**
     * 查询list
     */
    List<JSONObject> selectBatch();
}