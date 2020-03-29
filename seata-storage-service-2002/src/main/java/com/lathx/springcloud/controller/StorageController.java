package com.lathx.springcloud.controller;

import com.lathx.springcloud.dao.StorageDao;
import com.lathx.springcloud.domain.Order;
import com.lathx.springcloud.entites.CommonResult;
import com.lathx.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {
    @Resource
    private StorageDao storageDao;

    @PostMapping("/storage/decrease")
    public CommonResult create(@RequestParam("productId")Long productId,@RequestParam("count")Integer count) {
        storageDao.decrease(productId,count);
        return new CommonResult(200, "库存扣减成功");
    }
}
