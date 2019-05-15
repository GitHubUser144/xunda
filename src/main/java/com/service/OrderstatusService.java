package com.service;

import com.pojo.Orderstatus;

import java.util.List;

/**
 * 订单状态管理的业务层接口
 */
public interface OrderstatusService {

    /**
     * 获取所有的订单状态
     * @return
     */
    List<Orderstatus> getAll();

    /**
     * 添加订单状态
     * @param orderstatus
     */
    void save(Orderstatus orderstatus);

    /**
     * 查询订单状态的记录数
     * @return
     */
    long getCount();

    /**
     * 根据id查询订单状态
     * @param orderid
     * @return
     */
    Orderstatus getOrderStatusById(Integer orderid);

    /**
     * 更新订单的状态
     * @param orderstatus
     */
    void update(Orderstatus orderstatus);

    /**
     * 删除订单状态
     * @param orderid
     */
    void delete(Integer orderid);
}
