package com.robot.admin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * order_log
 * @author 
 */
@Data
public class OrderLog implements Serializable {
    private Integer id;

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * 管理员
     */
    private String manager;

    /**
     * 类型
     */
    private String controlLog;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}