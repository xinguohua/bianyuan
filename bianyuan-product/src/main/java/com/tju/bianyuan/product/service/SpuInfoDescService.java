package com.tju.bianyuan.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tju.common.utils.PageUtils;
import com.tju.bianyuan.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author xgh
 * @email 794707072@qq.com
 * @date 2020-11-05 17:37:43
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

