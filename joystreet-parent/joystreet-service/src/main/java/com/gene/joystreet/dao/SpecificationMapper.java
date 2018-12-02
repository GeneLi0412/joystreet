package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Specification;
import java.util.List;

public interface SpecificationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Specification record);

    Specification selectByPrimaryKey(String id);

    List<Specification> selectAll();

    int updateByPrimaryKey(Specification record);
}