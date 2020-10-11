package com.robot.admin.dao;

import com.robot.admin.pojo.Order;
import com.robot.admin.request.OrderList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单 dao
 */

public interface OrderDao {

    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * mybatis-generator 插入一条记录
     */
    int insert(Order record);

    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(Order record);

    /**
     * mybatis-generator 根据id查询
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(Order record);

    /**
     * 查询订单列表
     */
    List<Order> findOrderList(@Param("orderList") OrderList orderList);

    /**
     * 根据orderCode查询
     */
    Order findOrderByCode(@Param("orderCode") String orderCode);

    /**
     * 更新订单的物流信息
     */
    int updateOrderExpressByCode(Order order);

    /**
     * 退款
     */
    int refund(String orderCode);
}