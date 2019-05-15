package com.service;

import com.pojo.Carroad;

import java.util.List;

/**
 * 途径线路明细的业务层
 */
public interface CarroadService {

    /**
     * 根据运输车辆id查询途径线路明细的信息
     * @param transid
     * @return
     */
    List<Carroad> getCarroadById(Integer transid);
}
