package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Specificationoption;
import java.util.List;

public interface SpecificationoptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Specificationoption record);

    Specificationoption selectByPrimaryKey(Long id);

    List<Specificationoption> selectAll();

    int updateByPrimaryKey(Specificationoption record);
}