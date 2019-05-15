package com.mapper;

import com.pojo.Carroad;
import com.pojo.CarroadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarroadMapper {
    long countByExample(CarroadExample example);

    int deleteByExample(CarroadExample example);

    int deleteByPrimaryKey(Integer roadid);

    int insert(Carroad record);

    int insertSelective(Carroad record);

    List<Carroad> selectByExample(CarroadExample example);

    Carroad selectByPrimaryKey(Integer roadid);

    int updateByExampleSelective(@Param("record") Carroad record, @Param("example") CarroadExample example);

    int updateByExample(@Param("record") Carroad record, @Param("example") CarroadExample example);

    int updateByPrimaryKeySelective(Carroad record);

    int updateByPrimaryKey(Carroad record);
}