package com.robot.admin.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * species_option
 * @author 
 */
@Data
public class SpeciesOption implements Serializable {
    private Integer id;

    /**
     * 分类编号
     */
    private Integer speciesId;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图片
     */
    private String cateImg;

    /**
     * 跳转链接
     */
    private String url;

    private static final long serialVersionUID = 1L;
}