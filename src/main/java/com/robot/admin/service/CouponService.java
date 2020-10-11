package com.robot.admin.service;

import com.robot.admin.pojo.CouponTpl;
import com.robot.admin.request.CouponList;
import com.robot.admin.request.SendCoupon;
import com.robot.admin.util.Message;


public interface CouponService {

    /**
     * 查询优惠券列表
     */
    Message findCouponList(CouponList couponList);

    /**
     * 添加优惠券
     */
    Message addCoupon(CouponTpl couponTpl) throws Exception;

    /**
     * 查询优惠券
     */
    Message findCouponById(Integer couponId) throws Exception;

    /**
     * 删除优惠券
     */
    Message deleteCoupon(Integer couponId) throws Exception;

    /**
     * 发送优惠券
     */
    Message sendCoupon(SendCoupon sendCoupon)throws Exception;

}
