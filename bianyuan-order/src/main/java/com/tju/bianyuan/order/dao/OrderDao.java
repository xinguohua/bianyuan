package com.tju.bianyuan.order.dao;

import com.tju.bianyuan.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author xgh
 * @email 794707072@qq.com
 * @date 2020-11-06 19:35:52
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
