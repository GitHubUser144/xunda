package com.service.impl;

import com.mapper.CarMapper;
import com.pojo.Car;
import com.pojo.CarExample;
import com.service.CarServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarServce {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> getAll() {
        return carMapper.selectWithCustomerAreaResultMapByExample(null);
    }

    @Override
    public void save(Car car) {
        carMapper.insertSelective(car);
    }

    @Override
    public long getCount() {
        return carMapper.countByExample(null);
    }

    @Override
    public Car getCarByid(Integer carid) {
        return carMapper.selectWithCustomerAreaResultMapByPrimaryKey(carid);
    }

    @Override
    public void updateCar(Car car) {
        CarExample carExample = new CarExample();
        CarExample.Criteria criteria = carExample.createCriteria();
        criteria.andCaridEqualTo(car.getCarid());
        carMapper.updateByExample(car,carExample);
    }

    @Override
    public void deleteById(Integer carid) {
        carMapper.deleteByPrimaryKey(carid);
    }
}
