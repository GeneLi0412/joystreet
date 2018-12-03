package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Specification;
import com.gene.joystreet.entity.SpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecificationMapper {
    long countByExample(SpecificationExample example);

    int deleteByExample(SpecificationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Specification record);

    int insertSelective(Specification record);

    List<Specification> selectByExample(SpecificationExample example);

    Specification selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByExample(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}