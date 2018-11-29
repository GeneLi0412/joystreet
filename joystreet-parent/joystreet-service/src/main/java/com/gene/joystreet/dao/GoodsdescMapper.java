package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Goodsdesc;
import java.util.List;

public interface GoodsdescMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(Goodsdesc record);

    Goodsdesc selectByPrimaryKey(Long goodsId);

    List<Goodsdesc> selectAll();

    int updateByPrimaryKey(Goodsdesc record);
}