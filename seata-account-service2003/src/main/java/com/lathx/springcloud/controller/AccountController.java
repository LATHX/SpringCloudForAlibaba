package com.lathx.springcloud.controller;

import com.lathx.springcloud.dao.AccountDao;
import com.lathx.springcloud.dao.StorageDao;
import com.lathx.springcloud.domain.Order;
import com.lathx.springcloud.entites.CommonResult;
import com.lathx.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RestController
public class AccountController {
    @Resource
    private AccountDao accountDao;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
//        try {
//            TimeUnit.SECONDS.sleep(8);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId, money);
        return new CommonResult(200, "余额扣减成功");
    }
}
