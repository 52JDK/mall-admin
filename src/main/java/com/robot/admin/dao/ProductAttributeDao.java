package com.robot.admin.dao;

import com.robot.admin.pojo.ProductAttribute;

import java.util.List;

public interface ProductAttributeDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(ProductAttribute record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(ProductAttribute record);
    /**
     * mybatis-generator 根据id查询
     */
    ProductAttribute selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(ProductAttribute record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(ProductAttribute record);

    /**
     * 查询规格列表
     */
    List<ProductAttribute> findAttributeList(Integer type);
}