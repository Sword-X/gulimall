package com.mall.gulimall.product.dao;

import com.mall.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xuqf
 * @email xuqf@gmail.com
 * @date 2020-06-06 20:23:07
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
