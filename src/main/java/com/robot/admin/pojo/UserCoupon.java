package com.robot.admin.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserCoupon {

    /**
     * 用户uid
     */
    private String uid;

    /**
     * 券id
     */
    private String couponId;

    /**
     * 券模板id
     */
    private Integer couponTplId;

    /**
     * 券名称
     */
    private String couponName;

    /**
     * 券类型
     */
    private Integer type;

    /**
     * 券折扣
     */
    private BigDecimal discount;

    /**
     * 券满减
     */
    private BigDecimal amount;

    /**
     * 开始时间
     */
    private Date startAt;

    /**
     * 结束时间
     */
    private Date endAt;


    private String threshold;

    private String description;

    public static  List<UserCoupon> convertUserCoupon(List<String> uids, String couponId, CouponTpl couponTpl) {
        List<UserCoupon> userCoupons=new ArrayList<>();
        for(String uid:uids) {
            UserCoupon userCoupon = new UserCoupon();
            userCoupon.setUid(uid);
            userCoupon.setCouponId(couponId);
            userCoupon.setCouponName(couponTpl.getCouponName());
            if (couponTpl.getThreshold().compareTo(BigDecimal.ZERO) > 0) {
                if (couponTpl.getType() == 1) {
                    userCoupon.setThreshold("满" + couponTpl.getThreshold() + "元" + ",优惠" + couponTpl.getAmount() + "元");
                    userCoupon.setAmount(couponTpl.getAmount());
                } else {
                    userCoupon.setDiscount(couponTpl.getDiscount());
                    userCoupon.setThreshold("满" + couponTpl.getThreshold() + "元" + ",打" + couponTpl.getDiscount() + "折");
                }
            } else {
                if (couponTpl.getType() == 1) {
                    userCoupon.setThreshold("无使用门槛,可优惠" + couponTpl.getAmount() + "元");
                    userCoupon.setAmount(couponTpl.getAmount());
                } else {
                    userCoupon.setDiscount(couponTpl.getDiscount());
                    userCoupon.setThreshold("无使用门槛,打" + couponTpl.getDiscount() + "折");
                }
            }
            userCoupon.setType(couponTpl.getType());
            userCoupon.setEndAt(couponTpl.getInvalidDate());
            userCoupon.setStartAt(couponTpl.getValidDate());
            userCoupon.setDescription(couponTpl.getContent());
            userCoupon.setCouponTplId(couponTpl.getId());
            userCoupons.add(userCoupon);
        }
        return userCoupons;
    }

}
