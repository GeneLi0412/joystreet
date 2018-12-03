package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Contentcategory;
import com.gene.joystreet.entity.ContentcategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentcategoryMapper {
    long countByExample(ContentcategoryExample example);

    int deleteByExample(ContentcategoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(Contentcategory record);

    int insertSelective(Contentcategory record);

    List<Contentcategory> selectByExample(ContentcategoryExample example);

    Contentcategory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Contentcategory record, @Param("example") ContentcategoryExample example);

    int updateByExample(@Param("record") Contentcategory record, @Param("example") ContentcategoryExample example);

    int updateByPrimaryKeySelective(Contentcategory record);

    int updateByPrimaryKey(Contentcategory record);
}