package com.robot.admin.dao;

import com.robot.admin.pojo.SysRoles;

import java.util.List;

/**
 * 角色dao
 */
public interface SysRolesDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(SysRoles record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(SysRoles record);
    /**
     * mybatis-generator 根据id查询
     */
    SysRoles selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(SysRoles record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(SysRoles record);


}