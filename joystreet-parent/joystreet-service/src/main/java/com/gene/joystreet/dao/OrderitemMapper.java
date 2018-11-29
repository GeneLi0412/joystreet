package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Orderitem;
import java.util.List;

public interface OrderitemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Orderitem record);

    Orderitem selectByPrimaryKey(Long id);

    List<Orderitem> selectAll();

    int updateByPrimaryKey(Orderitem record);
}