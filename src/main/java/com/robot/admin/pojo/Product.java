package com.robot.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * product
 * @author 
 */
@Data
public class Product implements Serializable {
    private Integer id;

    /**
     * 商品编码
     */
    private String productId;

    /**
     * 品牌id
     */
    private Integer speciesOptionId;

    /**
     * sku名称
     */
    private String name;

    /**
     * 推荐
     */
    private Integer recommend;

    /**
     * 虚拟购买量
     */
    private Integer virtualNum;


    /**
     * 排序
     */
    private Integer sort;

    /**
     * 标题
     */
    private String title;

    /**
     * 主图
     */
    private String img;


    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 权益
     */
    private String rights;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 上下架
     */
    private int enable;

    private static final long serialVersionUID = 1L;
}