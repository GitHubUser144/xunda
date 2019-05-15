package com.mapper;

import com.pojo.Balance;
import com.pojo.BalanceExample;
import java.util.List;

import com.pojo.BalanceQuery;
import org.apache.ibatis.annotations.Param;

public interface BalanceMapper {
    long countByExample(BalanceExample example);

    int deleteByExample(BalanceExample example);

    int deleteByPrimaryKey(Integer balanceid);

    int insert(Balance record);

    int insertSelective(Balance record);

    List<Balance> selectByExample(BalanceExample example);

    List<Balance> selectWithCustomerUserByExample(Integer coustomerid);

    List<Balance> selectWithCustomerUser(BalanceExample example);

    List<Balance> selectWithCustomerUserByQuery(BalanceQuery balanceQuery);

    Balance selectByPrimaryKey(Integer balanceid);

    int updateByExampleSelective(@Param("record") Balance record, @Param("example") BalanceExample example);

    int updateByExample(@Param("record") Balance record, @Param("example") BalanceExample example);

    int updateByPrimaryKeySelective(Balance record);

    int updateByPrimaryKey(Balance record);
}