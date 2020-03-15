package com.lathx.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo(Integer id) {
        return "Payment OK, ID:" + id;
    }

    public String paymentInfoTimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Payment Timeout, ID:" + id;
    }
}
