package com.service;

import com.pojo.Cardetail;

import java.util.List;

/**
 * 订单明细的业务层
 */
public interface CardetailService {
    /**
     * 获取所有的订单明细
     * @return
     */
    List<Cardetail> getAll();

    /**
     * 根据
     * @param customerid
     * @return
     */
    List<Cardetail> getCardetail(Integer customerid);

    /**
     * 根据条件查询
     * @param cardetail
     * @return
     */
    List<Cardetail> getCardetailByQuery(Cardetail cardetail);


}
