package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Paylog;
import com.gene.joystreet.entity.PaylogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaylogMapper {
    long countByExample(PaylogExample example);

    int deleteByExample(PaylogExample example);

    int deleteByPrimaryKey(String outTradeNo);

    int insert(Paylog record);

    int insertSelective(Paylog record);

    List<Paylog> selectByExample(PaylogExample example);

    Paylog selectByPrimaryKey(String outTradeNo);

    int updateByExampleSelective(@Param("record") Paylog record, @Param("example") PaylogExample example);

    int updateByExample(@Param("record") Paylog record, @Param("example") PaylogExample example);

    int updateByPrimaryKeySelective(Paylog record);

    int updateByPrimaryKey(Paylog record);
}