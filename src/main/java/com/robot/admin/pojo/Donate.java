package com.robot.admin.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * donate
 * @author 
 */
@Data
public class Donate implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 金额
     */
    private Long money;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}