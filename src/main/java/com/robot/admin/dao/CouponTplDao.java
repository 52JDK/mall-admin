package com.robot.admin.dao;

import com.robot.admin.pojo.CouponTpl;
import com.robot.admin.request.CouponList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponTplDao {
    /**
     * mybatis-generator 自动生成 根据id 删除
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * mybatis-generator 插入一条记录
     */
    int insert(CouponTpl record);

    /**
     * mybatis-generator 插入一条记录 空字段不会写入
     */
    int insertSelective(CouponTpl record);

    /**
     * mybatis-generator 根据id查询
     */
    CouponTpl selectByPrimaryKey(Integer id);

    /**
     * mybatis-generator 更新
     */
    int updateByPrimaryKeySelective(CouponTpl record);

    /**
     * mybatis-generator 根据主键更新
     */
    int updateByPrimaryKey(CouponTpl record);

    /**
     * 查询优惠券的列表
     */
    List<CouponTpl> findCouponList(@Param("couponList") CouponList couponList);
}