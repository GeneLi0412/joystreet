package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Goodsdesc;
import com.gene.joystreet.entity.GoodsdescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsdescMapper {
    long countByExample(GoodsdescExample example);

    int deleteByExample(GoodsdescExample example);

    int deleteByPrimaryKey(String goodsId);

    int insert(Goodsdesc record);

    int insertSelective(Goodsdesc record);

    List<Goodsdesc> selectByExample(GoodsdescExample example);

    Goodsdesc selectByPrimaryKey(String goodsId);

    int updateByExampleSelective(@Param("record") Goodsdesc record, @Param("example") GoodsdescExample example);

    int updateByExample(@Param("record") Goodsdesc record, @Param("example") GoodsdescExample example);

    int updateByPrimaryKeySelective(Goodsdesc record);

    int updateByPrimaryKey(Goodsdesc record);
}