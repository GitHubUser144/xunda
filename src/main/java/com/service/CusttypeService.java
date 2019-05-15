package com.service;

import com.pojo.Customertype;

import java.util.List;

/**
 *  客户类型的业务层接口
 */
public interface CusttypeService {

    /**
     * 获取所有的客户类型
     * @return
     */
    List<Customertype> getAll();

    /**
     * 添加客户类型
     * @param customertype
     */
    void save(Customertype customertype);

    /**
     * 获取总记录数
     * @return
     */
    long getCount();

    /**
     * 根据id查询客户类型
     * @param customertypeid
     * @return
     */
    Customertype getCustTypeById(Integer customertypeid);

    /**
     * 根据客户类型
     * @param customertype
     */
    void update(Customertype customertype);

    /**
     * 删除客户类型
     * @param customertypeid
     */
    void delete(Integer customertypeid);
}
