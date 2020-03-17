package com.lathx.springcloud.service;

import org.springframework.stereotype.Service;
// 服务宕机的时候用FeignFallBack
// 服务熔断
@Service
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo(Long id) {
        return "paymentInfo fall back";
    }

    @Override
    public String paymentInfoTimeOut(Long id) {
        return "paymentInfoTimeOut fall back";
    }
}
