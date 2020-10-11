package com.robot.admin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_address
 * @author 
 */
@Data
public class UserAddress implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * uid
     */
    private String uid;

    /**
     * 电话
     */
    private String tel;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String county;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 区号
     */
    private String areaCode;

    /**
     * 邮编
     */
    private String postalCode;

    /**
     * 是否默认
     */
    private Byte deafult;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}