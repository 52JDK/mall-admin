package com.robot.admin.dao;


import com.robot.admin.pojo.ProductAttributeOption;

import java.util.List;

/**
 * 商品属性信息
 */
public interface ProductAttributeOptionDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(ProductAttributeOption record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(ProductAttributeOption record);
    /**
     * mybatis-generator 根据id查询
     */
    ProductAttributeOption selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(ProductAttributeOption record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(ProductAttributeOption record);

    /**
     * 查询列表
     */
    List<ProductAttributeOption> findList();
}