package com.robot.admin.dao;

import com.robot.admin.pojo.OrderLog;

import java.util.List;

/**
 * 订单日志 dao
 */
public interface OrderLogDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(OrderLog record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(OrderLog record);
    /**
     * mybatis-generator 根据id查询
     */
    OrderLog selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(OrderLog record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(OrderLog record);

    /**
     * 查询日志列表
     */
    List<OrderLog> findLogByCode(String orderCode);
}