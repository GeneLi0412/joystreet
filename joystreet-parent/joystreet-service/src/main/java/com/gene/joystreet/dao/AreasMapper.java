package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Areas;
import java.util.List;

public interface AreasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Areas record);

    Areas selectByPrimaryKey(Integer id);

    List<Areas> selectAll();

    int updateByPrimaryKey(Areas record);
}