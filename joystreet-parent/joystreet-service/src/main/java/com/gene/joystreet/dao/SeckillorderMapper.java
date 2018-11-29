package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Seckillorder;
import java.util.List;

public interface SeckillorderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Seckillorder record);

    Seckillorder selectByPrimaryKey(Long id);

    List<Seckillorder> selectAll();

    int updateByPrimaryKey(Seckillorder record);
}