package com.tju.bianyuan.member.feign;


import com.tju.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 调用远程服务
 * 这是一个声明式的远程调用
 */
@FeignClient("bianyuan-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/couponhistory/member/list")
    public R membercoupons();
}
