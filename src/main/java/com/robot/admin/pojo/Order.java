package com.robot.admin.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * order
 * @author 
 */
@Data
public class Order implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * uid
     */
    private String uid;

    /**
     * 应付金额
     */
    private BigDecimal payAmount;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 运费
     */
    private BigDecimal freightAmount;

    /**
     * 积分
     */
    private Integer point;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 地址id
     */
    private Integer addressId;

    /**
     * 券模板id
     */
    private Integer couponTplId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 商品数量
     */
    private Integer totalNum;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 快递单号
     */
    private String expressCode;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * 收货时间
     */
    private Date receiptTime;

    /**
     * 发货时间
     */
    private Date shipTime;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 支付时间
     */
    private Date payTime;


    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 收货人姓名
     */
    private String name;


    private static final long serialVersionUID = 1L;
}