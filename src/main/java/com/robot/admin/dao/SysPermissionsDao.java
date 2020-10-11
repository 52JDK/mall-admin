package com.robot.admin.dao;

import com.robot.admin.pojo.SysPermissions;

import java.util.List;

/**
 * 用户权限dao
 */
public interface SysPermissionsDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(SysPermissions record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(SysPermissions record);
    /**
     * mybatis-generator 根据id查询
     */
    SysPermissions selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(SysPermissions record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(SysPermissions record);

    /**
     * 查询列表
     */
    List<SysPermissions> list();
}