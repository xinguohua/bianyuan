package com.tju.bianyuan.order.dao;

import com.tju.bianyuan.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author xgh
 * @email 794707072@qq.com
 * @date 2020-11-06 19:35:52
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
