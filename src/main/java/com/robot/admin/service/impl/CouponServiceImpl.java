package com.robot.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.admin.dao.CouponTplDao;
import com.robot.admin.pojo.CouponTpl;
import com.robot.admin.pojo.UserCoupon;
import com.robot.admin.request.CouponList;
import com.robot.admin.request.SendCoupon;
import com.robot.admin.service.CouponService;
import com.robot.admin.util.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    private static final String couponCollection = "UserCoupon";

    @Resource
    private CouponTplDao couponTplDao;

    @Resource
    private BaseRedis baseRedis;

    @Override
    public Message findCouponList(CouponList couponList) {
        Page page = PageHelper.startPage(couponList.getPageNum(), couponList.getPageSize());
        List<CouponTpl> list = couponTplDao.findCouponList(couponList);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setTotal(page.getTotal());
        return Message.success(pageInfo);
    }


    @Override
    public Message addCoupon(CouponTpl couponTpl) throws Exception {
        if (couponTpl.getId() != null) {
            couponTplDao.updateByPrimaryKey(couponTpl);
        } else {
            couponTplDao.insert(couponTpl);
        }
        return Message.success();
    }


    @Override
    public Message findCouponById(Integer couponId) throws Exception {
        CouponTpl couponTpl = couponTplDao.selectByPrimaryKey(couponId);
        return Message.success(couponTpl);
    }


    @Override
    public Message deleteCoupon(Integer couponId) throws Exception {
        couponTplDao.deleteByPrimaryKey(couponId);
        return Message.success();
    }

    @Override
    public Message sendCoupon(SendCoupon sendCoupon) throws Exception {
        CouponTpl couponTpl = couponTplDao.selectByPrimaryKey(sendCoupon.getCouponId());
        if (couponTpl == null) {
            return Message.error(ErrorType.COUPON_TPL_NOT_EXIST);
        }
        if (couponTpl.getQuantity() < couponTpl.getSendQuantity()) {
            return Message.error(ErrorType.COUPON_NUM_MAX);
        }
        String couponId = createCouponId(sendCoupon.getCouponId(), couponTpl.getValidDate(), couponTpl.getInvalidDate());
        List<String> uids = Arrays.asList(sendCoupon.getUidList().split(","));
        List<UserCoupon> userCoupon = UserCoupon.convertUserCoupon(uids, couponId, couponTpl);
        MongoDBUtil.saveBatch(userCoupon,UserCoupon.class, couponCollection);
        CouponTpl updateCouponTpl = new CouponTpl();
        updateCouponTpl.setId(sendCoupon.getCouponId());
        updateCouponTpl.setSendQuantity(couponTpl.getSendQuantity());
        couponTplDao.updateByPrimaryKeySelective(updateCouponTpl);
        return Message.success(ErrorType.SUCCESS);
    }


    public String createCouponId(Integer tplId, Date startDate, Date endDate) {
        String id = RandomCodeUtil.getOrderCode();
        int times = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String key = String.format(String.format("COUPON_ID:::%s", tplId), sdf.format(new Date()));
        boolean result = baseRedis.sismember(key, id);
        while (result && (times < 20)) {
            times++;
            id = RandomCodeUtil.getOrderCode();
        }
        baseRedis.sadd(key, id);
        baseRedis.expire(key, (int) (endDate.getTime() - startDate.getTime()));
        return id;
    }
}
