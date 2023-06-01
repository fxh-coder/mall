package com.imooc.imoocmall.model.dao;

import com.imooc.imoocmall.model.pojo.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem row);

    int insertSelective(OrderItem row);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem row);

    int updateByPrimaryKey(OrderItem row);
}