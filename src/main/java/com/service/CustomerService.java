package com.service;

import com.pojo.Customer;
import com.pojo.CustomerExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户的业务层
 */
public interface CustomerService {

    /**
     *  获取所有的客户信息
     */
    List<Customer> getAllCustomer();

    /**
     * 添加客户
     * @param customer
     */
    void save(Customer customer);

    /**
     * 获取客户的总记录数
     * @return
     */
    long getCount();

    /**
     * 获取当前客户的信息
     * @param customerid
     * @return
     */
    Customer getCustomer(Integer customerid);

    /**
     * 更新用户信息
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     * 删除用户
     * @param customerid
     */
    void deleteCustomer(Integer customerid);

    /**
     *
     *
     * @param customer
     */
    List<Customer> getCustomerByCondition(Customer customer);
}
