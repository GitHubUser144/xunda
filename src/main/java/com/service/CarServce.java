package com.service;

import com.pojo.Car;

import java.util.List;

/**
 * 运输工具的业务层
 */
public interface CarServce {

    /**
     *  查询所有的运输工具
     * @return
     */
    List<Car> getAll();

    /**
     * 新增运输工具
     * @param car
     */
    void save(Car car);

    /**
     * 获取总记录数
     * @return
     */
    long getCount();

    /**
     * 根据id查询出运输工具
     * @param carid
     * @return
     */
    Car getCarByid(Integer carid);

    /**
     * 更新运输工具
     * @param car
     */
    void updateCar(Car car);

    /**
     * 删除运输工具
     * @param carid
     */
    void deleteById(Integer carid);
}
