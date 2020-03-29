package com.lathx.springcloud.dao;

import com.lathx.springcloud.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void create(Storage order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
