package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Brand;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    int deleteByPrimaryKey(String id);

    int insert(Brand record);

    Brand selectByPrimaryKey(String id);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand record);

    /**
     * 批量删除
     * @param ids
     */
	void deleteByPrimaryKeys(@Param("brandIds") List<String> brandIds);
}