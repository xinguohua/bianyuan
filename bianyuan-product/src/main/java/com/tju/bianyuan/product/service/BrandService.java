package com.tju.bianyuan.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tju.common.utils.PageUtils;
import com.tju.bianyuan.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author xgh
 * @email 794707072@qq.com
 * @date 2020-11-05 17:37:4311
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

