package com.mall.gulimall.coupon.dao;

import com.mall.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author xuqf
 * @email xuqf@gmail.com
 * @date 2020-06-06 21:49:02
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
