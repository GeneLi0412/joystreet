package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Paylog;
import java.util.List;

public interface PaylogMapper {
    int deleteByPrimaryKey(String outTradeNo);

    int insert(Paylog record);

    Paylog selectByPrimaryKey(String outTradeNo);

    List<Paylog> selectAll();

    int updateByPrimaryKey(Paylog record);
}