package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Seckillgoods;
import com.gene.joystreet.entity.SeckillgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillgoodsMapper {
    long countByExample(SeckillgoodsExample example);

    int deleteByExample(SeckillgoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Seckillgoods record);

    int insertSelective(Seckillgoods record);

    List<Seckillgoods> selectByExample(SeckillgoodsExample example);

    Seckillgoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Seckillgoods record, @Param("example") SeckillgoodsExample example);

    int updateByExample(@Param("record") Seckillgoods record, @Param("example") SeckillgoodsExample example);

    int updateByPrimaryKeySelective(Seckillgoods record);

    int updateByPrimaryKey(Seckillgoods record);
}