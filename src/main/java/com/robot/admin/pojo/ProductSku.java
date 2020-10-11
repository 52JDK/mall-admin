package com.robot.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * product_sku
 * @author 
 */
@Data
public class ProductSku implements Serializable {
    private Integer id;

    private String sku;

    private String productId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品品类编号
     */
    private Integer attrOne;

    private Integer attrTwo;


    /**
     * 简述
     */
    private String title;

    /**
     * 商品关键字
     */
    private String keywords;

    /**
     * 标签
     */
    private String tags;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 市场价格
     */
    private BigDecimal marketPrice;

    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 库存警告
     */
    private Integer warningStock;

    /**
     * 封面图
     */
    private String pictureUrl;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}