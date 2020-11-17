package com.tju.bianyuan.product.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tju.bianyuan.product.entity.CategoryEntity;
import com.tju.bianyuan.product.service.CategoryService;
import com.tju.common.utils.PageUtils;
import com.tju.common.utils.R;



/**
 * 商品三级分类
 *
 * @author xgh
 * @email 794707072@qq.com
 * @date 2020-11-06 15:51:09
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:category:list")
    public R list(){
        List<CategoryEntity> entities = categoryService.listWitTree();

        return R.ok().put("data", entities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     * @RequestBody获取请求题 必须是post请求
     * SpringMVC自动将请求体的数据（json）,转为对应的对象
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){

        //1、检查当前删除的菜单，是否被别的地方引用
        categoryService.removeMenuByIds(Arrays.asList(catIds));
        //categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
