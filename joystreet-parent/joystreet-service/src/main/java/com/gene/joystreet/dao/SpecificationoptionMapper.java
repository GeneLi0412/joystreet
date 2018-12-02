package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Specificationoption;
import java.util.List;

public interface SpecificationoptionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Specificationoption record);

    Specificationoption selectByPrimaryKey(String id);

    List<Specificationoption> selectAll();

    int updateByPrimaryKey(Specificationoption record);
}