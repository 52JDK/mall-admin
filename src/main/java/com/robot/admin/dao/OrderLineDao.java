package com.robot.admin.dao;

import com.robot.admin.pojo.OrderLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderLineDao {

    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * mybatis-generator 插入一条记录
     */
    int insert(OrderLine record);

    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(OrderLine record);

    /**
     * mybatis-generator 根据id查询
     */
    OrderLine selectByPrimaryKey(Integer id);

    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(OrderLine record);

    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(OrderLine record);

    /**
     * 查询订单行列表
     */
    List<OrderLine> findOrderLine(@Param("orderCode") String orderCode);
}