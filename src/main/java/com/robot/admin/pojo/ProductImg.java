package com.robot.admin.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * product_img
 * @author 
 */
@Data
public class ProductImg implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * product_id
     */
    private String productId;

    /**
     * 滚动图
     */
    private String rollImg;

    /**
     * 详细图
     */
    private String detailImg;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}