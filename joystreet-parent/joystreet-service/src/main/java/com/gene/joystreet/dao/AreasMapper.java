package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Areas;
import com.gene.joystreet.entity.AreasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreasMapper {
    long countByExample(AreasExample example);

    int deleteByExample(AreasExample example);

    int deleteByPrimaryKey(String id);

    int insert(Areas record);

    int insertSelective(Areas record);

    List<Areas> selectByExample(AreasExample example);

    Areas selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Areas record, @Param("example") AreasExample example);

    int updateByExample(@Param("record") Areas record, @Param("example") AreasExample example);

    int updateByPrimaryKeySelective(Areas record);

    int updateByPrimaryKey(Areas record);
}