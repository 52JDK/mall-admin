package com.robot.admin.dao;

import com.robot.admin.pojo.Product;
import com.robot.admin.request.EnableProduct;
import com.robot.admin.request.ProductDetail;
import com.robot.admin.request.ProductList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * mybatis-generator 插入一条记录
     */
    int insert(Product record);
    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(Product record);
    /**
     * mybatis-generator 根据id查询
     */
    Product selectByPrimaryKey(Integer id);
    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(Product record);
    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(Product record);

    /**
     * 查询商品list
     */
    List<Product> findProductList(@Param("productList") ProductList productList);

    /**
     * 根据商品id查询
     */
    Product findProductById(String productId);

    /**
     * 根据商品id删除
     */
    int deleteProductId(String productId);

    /**
     * 开启关闭商品
     */
    int enableProduct(@Param("enableProduct")EnableProduct enableProduct);

}