package com.mall.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.common.utils.PageUtils;
import com.mall.common.utils.Query;

import com.mall.gulimall.product.dao.CategoryDao;
import com.mall.gulimall.product.entity.CategoryEntity;
import com.mall.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 查询所有
        List<CategoryEntity> categoryEntityList = baseMapper.selectList(null);
        // 进行三级分类
        List<CategoryEntity> menus = categoryEntityList.stream().filter(menu -> menu.getParentCid() == 0)
                .map(menu -> {
                    menu.setChilderCategory(getChilds(menu,categoryEntityList));
                    return menu;
                })
                .sorted((menu1,menu2)->{
                    return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
                })
                .collect(Collectors.toList());
        return menus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        // TODO 1.检查当前删除的菜单，是否被别的地方引用

        // 2.逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    private List<CategoryEntity> getChilds(CategoryEntity current, List<CategoryEntity> all) {
        List<CategoryEntity> collect = all.stream().filter(menu -> menu.getParentCid() == current.getCatId())
                .map(menu -> {
                    menu.setChilderCategory(getChilds(menu, all));
                    return menu;
                }).sorted((menu1,menu2)->{
                    return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
                })
                .collect(Collectors.toList());
        return collect;
    }

}