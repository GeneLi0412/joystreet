package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Address;
import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(Address record);

    Address selectByPrimaryKey(String id);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);
}