package com.robot.admin.dao;

import com.robot.admin.pojo.ProductSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品sku dao
 */
public interface ProductSkuDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(ProductSku record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(ProductSku record);
    /**
     * mybatis-generator 根据id查询
     */
    ProductSku selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(ProductSku record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(ProductSku record);

    /**
     * 批量插入
     */
    int insertBatch(@Param("list") List<ProductSku> productSkuList);

    /**
     * 根据商品id删除
     */
    int deleteByProductId(String productId);

    /**
     * 根据商品id查询
     */
    List<ProductSku> findByProductId(String productId);

}