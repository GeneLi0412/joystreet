package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Specification;
import java.util.List;

public interface SpecificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Specification record);

    Specification selectByPrimaryKey(Long id);

    List<Specification> selectAll();

    int updateByPrimaryKey(Specification record);
}