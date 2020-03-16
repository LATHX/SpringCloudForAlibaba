package com.lathx.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo(Integer id) {
        return "Payment OK, ID:" + id;
    }

    // 超过2秒调用Hystrix
    // 运行异常也会调用Hystrix
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"
            )})
    public String paymentInfoTimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Payment Timeout, ID:" + id;
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "Please Wait Payment Timeout" + id;
    }
}
