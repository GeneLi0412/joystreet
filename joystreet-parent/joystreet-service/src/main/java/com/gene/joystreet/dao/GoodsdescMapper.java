package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Goodsdesc;
import java.util.List;

public interface GoodsdescMapper {
    int deleteByPrimaryKey(String goodsId);

    int insert(Goodsdesc record);

    Goodsdesc selectByPrimaryKey(String goodsId);

    List<Goodsdesc> selectAll();

    int updateByPrimaryKey(Goodsdesc record);
}