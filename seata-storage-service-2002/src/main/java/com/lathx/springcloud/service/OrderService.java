package com.lathx.springcloud.service;

import com.lathx.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    void create(Order order);

    void update(Long orderId, Integer status);
}
