package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Content;
import com.gene.joystreet.entity.ContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
    long countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Content record);

    int insertSelective(Content record);

    List<Content> selectByExample(ContentExample example);

    Content selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}