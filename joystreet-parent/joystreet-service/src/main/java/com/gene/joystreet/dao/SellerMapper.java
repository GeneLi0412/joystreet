package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Seller;
import java.util.List;

public interface SellerMapper {
    int deleteByPrimaryKey(String sellerId);

    int insert(Seller record);

    Seller selectByPrimaryKey(String sellerId);

    List<Seller> selectAll();

    int updateByPrimaryKey(Seller record);
}