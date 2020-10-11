package com.robot.admin.service;

import com.robot.admin.request.AddProduct;
import com.robot.admin.request.EnableProduct;
import com.robot.admin.request.ProductDetail;
import com.robot.admin.request.ProductList;
import com.robot.admin.util.Message;

public interface ProductService {

    /**
     * 查询商品列表
     */
    Message ProductList(ProductList productList);


    /**
     * 查询详情
     */
    Message productDetail(ProductDetail productDetail) throws Exception;

    /**
     * 商品上下架
     */
    Message enableProduct(EnableProduct enableProduct)throws Exception;

    /**
     * 商品添加
     */
    Message ProductAdd(AddProduct addProduct) throws Exception;

    /**
     * 删除商品
     */
    Message deleteProduct(ProductDetail detail) throws Exception;

    /**
     * 查询商品规格信息
     */
    Message findSpecies() throws Exception;
}
