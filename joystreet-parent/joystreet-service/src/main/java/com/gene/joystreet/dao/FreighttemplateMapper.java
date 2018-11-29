package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Freighttemplate;
import java.util.List;

public interface FreighttemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Freighttemplate record);

    Freighttemplate selectByPrimaryKey(Long id);

    List<Freighttemplate> selectAll();

    int updateByPrimaryKey(Freighttemplate record);
}