package com.lathx.springcloud.service.impl;

import com.lathx.springcloud.dao.PaymentDao;
import com.lathx.springcloud.entites.Payment;
import org.springframework.stereotype.Service;
import com.lathx.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
