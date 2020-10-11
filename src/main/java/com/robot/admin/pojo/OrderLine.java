package com.robot.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * order_line
 * @author 
 */
@Data
public class OrderLine implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * sku
     */
    private String sku;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 图片
     */
    private String image;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}