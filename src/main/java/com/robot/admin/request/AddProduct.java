package com.robot.admin.request;

import com.robot.admin.pojo.ImageInfo;
import lombok.Data;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 添加商品
 */
@Data
public class AddProduct {

    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 品牌id
     */
    private Integer brandId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 虚拟购买量
     */
    private int virtualNum;

    /**
     * 排序
     */
    private int sort;

    /**
     * 是否是推荐
     */
    private boolean recommend;

    /**
     * 权益
     */
    private String rights;

    /**
     * 封面图
     */
    private String img;

    /**
     * 主图
     */
    private List<ImageInfo> mainImg;

    /**
     * 轮播图
     */
    private List<ImageInfo> rollImg;

    /**
     * 详情图
     */
    private List<ImageInfo> detailImg;

    /**
     * 简介
     */
    private String introduction;

    private List<AddProductList> tableData;

}
