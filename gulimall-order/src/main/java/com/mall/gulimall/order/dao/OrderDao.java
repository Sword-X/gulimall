package com.mall.gulimall.order.dao;

import com.mall.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author xuqf
 * @email xuqf@gmail.com
 * @date 2020-06-06 22:21:09
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
