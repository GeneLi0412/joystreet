package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    Order selectByPrimaryKey(String orderId);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}