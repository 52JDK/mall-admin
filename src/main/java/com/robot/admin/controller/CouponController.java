package com.robot.admin.controller;

import com.robot.admin.pojo.CouponTpl;
import com.robot.admin.request.CouponList;
import com.robot.admin.request.EditCoupon;
import com.robot.admin.request.SendCoupon;
import com.robot.admin.service.CouponService;
import com.robot.admin.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 优惠券controller
 */

@Controller
@RequestMapping("/coupon")
@CrossOrigin
@Slf4j
public class CouponController {

    @Resource
    private CouponService couponService;

    /**
     * 优惠券列表
     * @param couponList
     * @return
     */
    @RequiresPermissions("coupon:list")
    @RequestMapping("/list")
    @ResponseBody
    public Message couponList(@RequestBody CouponList couponList) {
            return couponService.findCouponList(couponList);
    }

    /**
     * 添加优惠券
     * @param couponTpl
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    @ResponseBody
    @RequiresPermissions("coupon:add")
    public Message addCoupon(@RequestBody CouponTpl couponTpl) throws Exception {
            return couponService.addCoupon(couponTpl);
    }

    /**
     * 查询优惠券
     * @param editCoupon
     * @return
     * @throws Exception
     */
    @RequestMapping("/findCouponById")
    @ResponseBody
    @RequiresPermissions("coupon:findCouponById")
    public Message findCouponById(@RequestBody EditCoupon editCoupon) throws Exception {
            return couponService.findCouponById(editCoupon.getCouponId());
    }

    /**
     * 删除优惠券
     * @param editCoupon
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteCoupon")
    @ResponseBody
    @RequiresPermissions("coupon:deleteCoupon")
    public Message deleteCoupon(@RequestBody EditCoupon editCoupon) throws Exception {
           return couponService.deleteCoupon(editCoupon.getCouponId());

    }

    /**
     * 发送优惠券
     * @param sendCoupon
     * @return
     * @throws Exception
     */

    @RequestMapping("/sendCoupon")
    @ResponseBody
    @RequiresPermissions("coupon:sendCoupon")
    public Message sendCoupon(@RequestBody SendCoupon sendCoupon) throws Exception {
            return couponService.sendCoupon(sendCoupon);
    }
}
