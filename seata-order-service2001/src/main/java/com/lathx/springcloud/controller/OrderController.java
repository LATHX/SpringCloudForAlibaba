package com.lathx.springcloud.controller;

import com.lathx.springcloud.domain.Storage;
import com.lathx.springcloud.entites.CommonResult;
import com.lathx.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Storage order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
