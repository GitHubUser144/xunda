package com.mapper;

import com.pojo.Transcar;
import com.pojo.TranscarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TranscarMapper {
    long countByExample(TranscarExample example);

    int deleteByExample(TranscarExample example);

    int deleteByPrimaryKey(Integer transid);

    int insert(Transcar record);

    int insertSelective(Transcar record);

    List<Transcar> selectByExample(TranscarExample example);

    List<Transcar> selectWithCarSendTypeByExample(TranscarExample example);

    Transcar selectByPrimaryKey(Integer transid);

    Transcar selectWithCarSendTypeByPrimaryKey(Integer transid);

    int updateByExampleSelective(@Param("record") Transcar record, @Param("example") TranscarExample example);

    int updateByExample(@Param("record") Transcar record, @Param("example") TranscarExample example);

    int updateByPrimaryKeySelective(Transcar record);

    int updateByPrimaryKey(Transcar record);
}