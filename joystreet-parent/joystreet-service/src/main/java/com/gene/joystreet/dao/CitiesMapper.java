package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Cities;
import java.util.List;

public interface CitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cities record);

    Cities selectByPrimaryKey(Integer id);

    List<Cities> selectAll();

    int updateByPrimaryKey(Cities record);
}