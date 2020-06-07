package com.mall.gulimall.member.dao;

import com.mall.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author xuqf
 * @email xuqf@gmail.com
 * @date 2020-06-06 22:14:54
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
