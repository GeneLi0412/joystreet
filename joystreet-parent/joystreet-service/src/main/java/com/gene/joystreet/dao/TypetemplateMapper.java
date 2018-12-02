package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Typetemplate;
import java.util.List;

public interface TypetemplateMapper {
    int deleteByPrimaryKey(String id);

    int insert(Typetemplate record);

    Typetemplate selectByPrimaryKey(String id);

    List<Typetemplate> selectAll();

    int updateByPrimaryKey(Typetemplate record);
}