package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Content;
import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Content record);

    Content selectByPrimaryKey(String id);

    List<Content> selectAll();

    int updateByPrimaryKey(Content record);
}