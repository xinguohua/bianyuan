package com.tju.bianyuan.member.dao;

import com.tju.bianyuan.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author xgh
 * @email 794707072@qq.com
 * @date 2020-11-06 19:15:31
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
