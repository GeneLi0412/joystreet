package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Provinces;
import com.gene.joystreet.entity.ProvincesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvincesMapper {
    long countByExample(ProvincesExample example);

    int deleteByExample(ProvincesExample example);

    int deleteByPrimaryKey(String id);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    List<Provinces> selectByExample(ProvincesExample example);

    Provinces selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Provinces record, @Param("example") ProvincesExample example);

    int updateByExample(@Param("record") Provinces record, @Param("example") ProvincesExample example);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);
}