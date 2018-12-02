package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Item;
import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(Item record);

    Item selectByPrimaryKey(String id);

    List<Item> selectAll();

    int updateByPrimaryKey(Item record);
}