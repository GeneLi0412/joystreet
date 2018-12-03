package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Specificationoption;
import com.gene.joystreet.entity.SpecificationoptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecificationoptionMapper {
    long countByExample(SpecificationoptionExample example);

    int deleteByExample(SpecificationoptionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Specificationoption record);

    int insertSelective(Specificationoption record);

    List<Specificationoption> selectByExample(SpecificationoptionExample example);

    Specificationoption selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Specificationoption record, @Param("example") SpecificationoptionExample example);

    int updateByExample(@Param("record") Specificationoption record, @Param("example") SpecificationoptionExample example);

    int updateByPrimaryKeySelective(Specificationoption record);

    int updateByPrimaryKey(Specificationoption record);
}