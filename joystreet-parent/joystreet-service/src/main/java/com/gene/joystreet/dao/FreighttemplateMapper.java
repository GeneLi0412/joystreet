package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Freighttemplate;
import java.util.List;

public interface FreighttemplateMapper {
    int deleteByPrimaryKey(String id);

    int insert(Freighttemplate record);

    Freighttemplate selectByPrimaryKey(String id);

    List<Freighttemplate> selectAll();

    int updateByPrimaryKey(Freighttemplate record);
}