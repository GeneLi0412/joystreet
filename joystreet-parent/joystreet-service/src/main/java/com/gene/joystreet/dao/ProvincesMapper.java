package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Provinces;
import java.util.List;

public interface ProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provinces record);

    Provinces selectByPrimaryKey(Integer id);

    List<Provinces> selectAll();

    int updateByPrimaryKey(Provinces record);
}