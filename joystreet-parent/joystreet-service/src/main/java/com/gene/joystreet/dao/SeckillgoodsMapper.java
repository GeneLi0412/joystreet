package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Seckillgoods;
import java.util.List;

public interface SeckillgoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Seckillgoods record);

    Seckillgoods selectByPrimaryKey(String id);

    List<Seckillgoods> selectAll();

    int updateByPrimaryKey(Seckillgoods record);
}