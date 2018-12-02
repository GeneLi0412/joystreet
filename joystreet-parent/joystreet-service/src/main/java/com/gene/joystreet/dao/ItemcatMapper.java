package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Itemcat;
import java.util.List;

public interface ItemcatMapper {
    int deleteByPrimaryKey(String id);

    int insert(Itemcat record);

    Itemcat selectByPrimaryKey(String id);

    List<Itemcat> selectAll();

    int updateByPrimaryKey(Itemcat record);
}