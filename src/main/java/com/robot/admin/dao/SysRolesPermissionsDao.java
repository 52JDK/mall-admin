package com.robot.admin.dao;

import com.alibaba.fastjson.JSONObject;
import com.robot.admin.pojo.SysRolesPermissions;

import java.util.List;

/**
 * 用户的角色权限
 */
public interface SysRolesPermissionsDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Long id);

    /**
     * mybatis-generator 插入一条记录
     */
    int insert(SysRolesPermissions record);

    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(SysRolesPermissions record);

    /**
     * mybatis-generator 根据id查询
     */
    SysRolesPermissions selectByPrimaryKey(Long id);

    /**
     * mybatis-generator 更新一条记录
     */
    int updateByPrimaryKeySelective(SysRolesPermissions record);

    /**
     * mybatis-generator 更新一条记录 空字段不会写入
     */
    int updateByPrimaryKey(SysRolesPermissions record);

    /**
     * 查询某个用户的权限列表
     */
    List<SysRolesPermissions> findPermissionList(Integer uid);

    /**
     * 查询所有权限
     */
    List<JSONObject> listAllPermission();

    /**
     * 批量插入
     */
    int insertBatch(List<SysRolesPermissions> list);

    /**
     * 根据uid删除
     */
    int deleteByUid(Integer uid);
}