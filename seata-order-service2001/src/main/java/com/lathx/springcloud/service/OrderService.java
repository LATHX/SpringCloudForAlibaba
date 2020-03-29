package com.lathx.springcloud.service;

import com.lathx.springcloud.domain.Storage;

public interface OrderService {
    void create(Storage order);

    void update(Long userId, Integer status);
}
