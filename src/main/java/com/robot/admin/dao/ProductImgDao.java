package com.robot.admin.dao;

import com.robot.admin.pojo.ProductImg;

import java.util.List;

/**
 * 商品图片 dao
 */
public interface ProductImgDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(ProductImg record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(ProductImg record);
    /**
     * mybatis-generator 根据id查询
     */
    ProductImg selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByProductId(ProductImg record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(ProductImg record);

    /**
     * 根据id删除
     */
    int deleteByProductId(String productId);

    /**
     * 根据商品id查询
     */
    ProductImg findByProductId(String productId);
}