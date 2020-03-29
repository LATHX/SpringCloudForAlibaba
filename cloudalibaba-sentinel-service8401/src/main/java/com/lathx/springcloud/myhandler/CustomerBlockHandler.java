package com.lathx.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lathx.springcloud.entites.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "服务不可用Exception");
    }

}
