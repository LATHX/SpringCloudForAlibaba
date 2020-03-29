package com.lathx.springcloud.service.impl;

import com.lathx.springcloud.dao.OrderDao;
import com.lathx.springcloud.domain.Storage;
import com.lathx.springcloud.service.AccountService;
import com.lathx.springcloud.service.OrderService;
import com.lathx.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Storage order) {
        log.info("新建订单");
        orderDao.create(order);

        log.info("库存扣减");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("账户余额扣减");
        accountService.decrease(order.getProductId(), order.getMoney());

        log.info("修改订单状态");
        orderDao.update(order.getUserId(), 0);
    }

    @Override
    public void update(Long userId, Integer status) {
        orderDao.update(userId, status);
    }
}
