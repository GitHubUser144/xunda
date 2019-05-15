package com.mapper;

import com.pojo.Cardetail;
import com.pojo.CardetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardetailMapper {
    long countByExample(CardetailExample example);

    int deleteByExample(CardetailExample example);

    int deleteByPrimaryKey(String detailid);

    int insert(Cardetail record);

    int insertSelective(Cardetail record);

    List<Cardetail> selectByExample(CardetailExample example);

    List<Cardetail> selectWithTranscarPaidtypeUsersByExample(CardetailExample example);

    List<Cardetail> selectWithTranscarPaidtypeUsersByCoustomerId(Integer coustomerId);

    List<Cardetail> selectWithTranscarPaidtypeUsersByQuery(Cardetail cardetail);

    Cardetail selectByPrimaryKey(String detailid);

    int updateByExampleSelective(@Param("record") Cardetail record, @Param("example") CardetailExample example);

    int updateByExample(@Param("record") Cardetail record, @Param("example") CardetailExample example);

    int updateByPrimaryKeySelective(Cardetail record);

    int updateByPrimaryKey(Cardetail record);
}