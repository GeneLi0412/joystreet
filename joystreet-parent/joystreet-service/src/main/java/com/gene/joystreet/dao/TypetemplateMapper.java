package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Typetemplate;
import java.util.List;

public interface TypetemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Typetemplate record);

    Typetemplate selectByPrimaryKey(Long id);

    List<Typetemplate> selectAll();

    int updateByPrimaryKey(Typetemplate record);
}