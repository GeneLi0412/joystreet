package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Itemcat;
import java.util.List;

public interface ItemcatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Itemcat record);

    Itemcat selectByPrimaryKey(Long id);

    List<Itemcat> selectAll();

    int updateByPrimaryKey(Itemcat record);
}