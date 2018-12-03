package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Freighttemplate;
import com.gene.joystreet.entity.FreighttemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreighttemplateMapper {
    long countByExample(FreighttemplateExample example);

    int deleteByExample(FreighttemplateExample example);

    int deleteByPrimaryKey(String id);

    int insert(Freighttemplate record);

    int insertSelective(Freighttemplate record);

    List<Freighttemplate> selectByExample(FreighttemplateExample example);

    Freighttemplate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Freighttemplate record, @Param("example") FreighttemplateExample example);

    int updateByExample(@Param("record") Freighttemplate record, @Param("example") FreighttemplateExample example);

    int updateByPrimaryKeySelective(Freighttemplate record);

    int updateByPrimaryKey(Freighttemplate record);
}