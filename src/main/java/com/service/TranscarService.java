package com.service;

import com.pojo.Transcar;

import java.util.List;

/**
 * 车辆调度的业务层
 */
public interface TranscarService {

    /**
     * 查询所有的车辆调度的信息
     * @return
     */
    List<Transcar> getAllTransCar();

    /**
     * 根据车辆的id查询车辆的信息
     * @param tradsid
     * @return
     */
    Transcar getTransCarByTransId(Integer tradsid);

    /**
     * 根据车辆的状态查询车辆的信息
     * @param status
     * @return
     */
    List<Transcar> getTransCarByCarStatus(String status);

    /**
     * 修改车辆的状态
     * @param transid
     */
    void updateTranscarStatusByTransId(Integer transid,String status);

    /**
     * 修改车辆的信息
     * @param transcar
     */
    void updateTranscar(Transcar transcar);

    /**
     * 添加车辆调度
     * @param transcar
     */
    void save(Transcar transcar);

    /**
     * 获取总记录数
     * @return
     */
    Long getCount();
}
