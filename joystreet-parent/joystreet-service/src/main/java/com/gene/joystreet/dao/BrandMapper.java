package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Brand;
import com.gene.joystreet.entity.BrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(String id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}