package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Seckillgoods;
import java.util.List;

public interface SeckillgoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Seckillgoods record);

    Seckillgoods selectByPrimaryKey(Long id);

    List<Seckillgoods> selectAll();

    int updateByPrimaryKey(Seckillgoods record);
}