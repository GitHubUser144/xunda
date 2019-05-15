package com.mapper;

import com.pojo.Customer;
import com.pojo.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer customerid);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    List<Customer> selectByExampleWithPaidAreaCustomerType(CustomerExample example);

    Customer selectByPrimaryKey(Integer customerid);

    Customer selectByExampleWithPaidAreaCustomerTypeByPrimaryKey(Integer customerid);

    List<Customer> selectByExampleWithPaidAreaCustomerTypeByQuery(Customer customer);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}