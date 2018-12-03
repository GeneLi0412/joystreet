package com.gene.joystreet.dao;

import com.gene.joystreet.entity.Typetemplate;
import com.gene.joystreet.entity.TypetemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypetemplateMapper {
    long countByExample(TypetemplateExample example);

    int deleteByExample(TypetemplateExample example);

    int deleteByPrimaryKey(String id);

    int insert(Typetemplate record);

    int insertSelective(Typetemplate record);

    List<Typetemplate> selectByExample(TypetemplateExample example);

    Typetemplate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Typetemplate record, @Param("example") TypetemplateExample example);

    int updateByExample(@Param("record") Typetemplate record, @Param("example") TypetemplateExample example);

    int updateByPrimaryKeySelective(Typetemplate record);

    int updateByPrimaryKey(Typetemplate record);
}