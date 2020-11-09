package com.tju.bianyuan.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tju.common.utils.PageUtils;
import com.tju.bianyuan.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author xgh
 * @email 794707072@qq.com
 * @date 2020-11-06 19:43:36
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

