package com.mall.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.mall.common.valid.ListVal;
import com.mall.common.valid.ProductAdd;
import com.mall.common.valid.ProductUpdate;
import com.mall.common.valid.ProductUpdateStatus;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author xuqf
 * @email xuqf@gmail.com
 * @date 2020-06-06 20:23:07
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@Null(message = "新增品牌ID必须为空",groups = {ProductAdd.class})
	@NotNull(message = "修改品牌ID不能为空",groups = {ProductUpdate.class, ProductUpdateStatus.class})
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空",groups = {ProductAdd.class,ProductUpdate.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "logo地址不能为空",groups = {ProductAdd.class})
	@URL(message = "logo地址必须为正确的URL地址",groups = {ProductAdd.class,ProductUpdate.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示],自定义校验
	 */
	@ListVal(vals = {0,1},groups = {ProductAdd.class,ProductUpdate.class,ProductUpdateStatus.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotBlank(groups = {ProductAdd.class},message = "首字母不能为空")
	@Pattern(regexp = "^[a-zA-Z]$",message = "首字母必须为a-z或A-Z的一位字母",groups = {ProductAdd.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups = {ProductAdd.class},message = "排序字段不能为空")
	@Min(value = 0,message = "排序字段必须为大于0的整数",groups = {ProductAdd.class,ProductUpdate.class})
	private Integer sort;

}
