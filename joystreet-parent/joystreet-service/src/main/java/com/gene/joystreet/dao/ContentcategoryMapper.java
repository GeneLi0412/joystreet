package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Contentcategory;
import java.util.List;

public interface ContentcategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Contentcategory record);

    Contentcategory selectByPrimaryKey(String id);

    List<Contentcategory> selectAll();

    int updateByPrimaryKey(Contentcategory record);
}