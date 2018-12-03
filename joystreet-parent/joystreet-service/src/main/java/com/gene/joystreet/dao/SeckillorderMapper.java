package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Seckillorder;
import com.gene.joystreet.entity.SeckillorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillorderMapper {
    long countByExample(SeckillorderExample example);

    int deleteByExample(SeckillorderExample example);

    int deleteByPrimaryKey(String id);

    int insert(Seckillorder record);

    int insertSelective(Seckillorder record);

    List<Seckillorder> selectByExample(SeckillorderExample example);

    Seckillorder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Seckillorder record, @Param("example") SeckillorderExample example);

    int updateByExample(@Param("record") Seckillorder record, @Param("example") SeckillorderExample example);

    int updateByPrimaryKeySelective(Seckillorder record);

    int updateByPrimaryKey(Seckillorder record);
}