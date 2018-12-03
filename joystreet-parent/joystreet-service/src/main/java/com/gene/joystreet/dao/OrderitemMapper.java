package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Orderitem;
import com.gene.joystreet.entity.OrderitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderitemMapper {
    long countByExample(OrderitemExample example);

    int deleteByExample(OrderitemExample example);

    int deleteByPrimaryKey(String id);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    List<Orderitem> selectByExample(OrderitemExample example);

    Orderitem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByExample(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);
}