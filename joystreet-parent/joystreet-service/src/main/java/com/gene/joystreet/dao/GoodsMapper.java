package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Goods;
import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    Goods selectByPrimaryKey(String id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
}