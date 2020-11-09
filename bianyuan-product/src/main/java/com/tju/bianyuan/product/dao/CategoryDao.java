package com.tju.bianyuan.product.dao;

import com.tju.bianyuan.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xgh
 * @email 794707072@qq.com
 * @date 2020-11-05 17:37:43
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
