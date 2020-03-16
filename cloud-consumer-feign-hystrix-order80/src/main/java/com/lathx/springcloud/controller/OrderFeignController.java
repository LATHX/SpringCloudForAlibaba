package com.lathx.springcloud.controller;

import com.lathx.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentInfo(id);
    }


    // 超过2秒调用Hystrix
    // 运行异常也会调用Hystrix
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"
            )})
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String PaymentFeignTimeout(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

    public String paymentInfoTimeOutHandler(Long id) {
        return "Please Wait,请稍后再试, Payment Timeout" + id;
    }
}
