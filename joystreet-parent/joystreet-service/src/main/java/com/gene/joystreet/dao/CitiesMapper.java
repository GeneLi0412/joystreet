package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Cities;
import java.util.List;

public interface CitiesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cities record);

    Cities selectByPrimaryKey(String id);

    List<Cities> selectAll();

    int updateByPrimaryKey(Cities record);
}