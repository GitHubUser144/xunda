package com.service.impl;

import com.mapper.CustomerMapper;
import com.pojo.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getAllCustomer() {
        return customerMapper.selectByExampleWithPaidAreaCustomerType(null);
    }

    @Override
    public void save(Customer customer) {
        customerMapper.insertSelective(customer);
    }

    @Override
    public long getCount() {
        return customerMapper.countByExample(null);
    }

    @Override
    public Customer getCustomer(Integer customerid) {
        return customerMapper.selectByExampleWithPaidAreaCustomerTypeByPrimaryKey(customerid);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public void deleteCustomer(Integer customerid) {
        customerMapper.deleteByPrimaryKey(customerid);
    }

    @Override
    public List<Customer> getCustomerByCondition(Customer customer) {
       return customerMapper.selectByExampleWithPaidAreaCustomerTypeByQuery(customer);
    }


}
