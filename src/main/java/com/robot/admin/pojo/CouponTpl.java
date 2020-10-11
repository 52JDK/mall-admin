package com.robot.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * coupon_tpl
 * @author 
 */
@Data
public class CouponTpl implements Serializable {
    private Integer id;

    /**
     * 券名称
     */
    private String couponName;

    /**
     * 描述
     */
    private String content;

    /**
     * 券类型
     */
    private Integer type;

    /**
     * 打几折
     */
    private BigDecimal discount;

    /**
     * 减多少钱
     */
    private BigDecimal amount;

    /**
     * 门槛
     */
    private BigDecimal threshold;

    /**
     * 发送数量
     */
    private Integer sendQuantity;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 生效时间
     */
    private Date validDate;

    /**
     * 失效时间
     */
    private Date invalidDate;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}