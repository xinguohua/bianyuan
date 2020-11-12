package com.tju.bianyuan.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tju.common.utils.PageUtils;
import com.tju.common.utils.Query;

import com.tju.bianyuan.product.dao.CategoryDao;
import com.tju.bianyuan.product.entity.CategoryEntity;
import com.tju.bianyuan.product.service.CategoryService;


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

//    @Override
//    public List<CategoryEntity> listWitTree() {
//        //1 查出所有分类
//        List<CategoryEntity> entities = baseMapper.selectList(null);
//        //2 组装成父子的树形结构
//        // 2.1 找到所有的一级分类(一级分类的parent_id=0)
//        List<CategoryEntity> level1Menus=entities.stream().filter(categoryEntity ->
//                categoryEntity.getParentCid() ==0
//        ).map((menu)->{
//            //2.2 递归设置每一个菜单的子菜单
//            menu.setChildren(getChildrens(menu,entities));
//            return menu;
//            //2.3 对菜单进行排序
//        }).sorted((menu1,menu2)-> {
//                    return menu1.getSort()-menu2.getSort();
//                }
//        ).collect(Collectors.toList());
//        System.out.println(level1Menus.getClass());
//        return level1Menus;
//    }
    @Override
    public List<CategoryEntity> listWitTree() {
        //1 查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2 组装成父子的树形结构
        // 2.1 找到所有的一级分类(一级分类的parent_id=0)
        List<CategoryEntity> parententities =new ArrayList<>();
        for (CategoryEntity entity : entities) {
            if (entity.getParentCid()==0){
                parententities.add(entity);
            }
        }
        //2.2 递归设置每一个菜单的子菜单
        for (CategoryEntity parententity : parententities) {
            parententity.setChildren(getChildrens(parententity,entities));
        }

        // 2.3 对根菜单按sort_id升序排序
        Collections.sort(parententities, new Comparator<CategoryEntity>() {
            @Override
            public int compare(CategoryEntity o1, CategoryEntity o2) {
                int o1sort;
                if (o1.getSort()==null){
                    o1sort=0;
                }else{
                    o1sort=o1.getSort();
                }

                int o2sort;
                if (o1.getSort()==null){
                    o2sort=0;
                }else{
                    o2sort=o2.getSort();
                }
                return o1sort-o2sort;
            }
        });

        return parententities;

    }

//    //递归查找所有菜单子菜单
//    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all)
//    {
//        List<CategoryEntity> childrens = all.stream().filter(categoryEntity -> {
//            return categoryEntity.getParentCid() == root.getCatId();
//        }).map(categoryEntity -> {
//            // 1 找到子菜单
//            categoryEntity.setChildren(getChildrens(categoryEntity, all));
//            return categoryEntity;
//        }).sorted((menu1, menu2) -> {
//            // 2 菜单排序
//            return (menu1.getSort() ==null ? 0:menu1.getSort())- (menu2.getSort()==null?0:menu2.getSort());
//        }).collect(Collectors.toList());
//
//        return childrens;
//    }

    //递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all)
    {
        List<CategoryEntity> childrens= new ArrayList<>();
        for (CategoryEntity categoryEntity : all) {
            if (categoryEntity.getParentCid() == root.getCatId()) {
                childrens.add(categoryEntity);
            }
        }
        for (CategoryEntity children : childrens) {
            children.setChildren(getChildrens(children,all));
        }
        // 2 对子菜单按sort_id升序排序
        Collections.sort(childrens, new Comparator<CategoryEntity>() {
            @Override
            public int compare(CategoryEntity o1, CategoryEntity o2) {
                int o1sort;
                if (o1.getSort()==null){
                    o1sort=0;
                }else{
                    o1sort=o1.getSort();
                }

                int o2sort;
                if (o1.getSort()==null){
                    o2sort=0;
                }else{
                    o2sort=o2.getSort();
                }
                return o1sort-o2sort;
            }
        });

        return childrens;
    }

}