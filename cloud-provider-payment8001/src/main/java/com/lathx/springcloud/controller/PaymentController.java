package com.lathx.springcloud.controller;

import com.lathx.springcloud.entites.CommonResult;
import com.lathx.springcloud.entites.Payment;
import com.lathx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "SUCCESS", result);
        } else {
            return new CommonResult(500, "Error");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null) {
            return new CommonResult(200, "SUCCESS", paymentById);
        } else {
            return new CommonResult(500, "Error");
        }
    }
}
