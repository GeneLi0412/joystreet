package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Itemcat;
import com.gene.joystreet.entity.ItemcatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemcatMapper {
    long countByExample(ItemcatExample example);

    int deleteByExample(ItemcatExample example);

    int deleteByPrimaryKey(String id);

    int insert(Itemcat record);

    int insertSelective(Itemcat record);

    List<Itemcat> selectByExample(ItemcatExample example);

    Itemcat selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Itemcat record, @Param("example") ItemcatExample example);

    int updateByExample(@Param("record") Itemcat record, @Param("example") ItemcatExample example);

    int updateByPrimaryKeySelective(Itemcat record);

    int updateByPrimaryKey(Itemcat record);
}