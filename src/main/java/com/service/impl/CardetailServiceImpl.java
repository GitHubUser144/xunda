package com.service.impl;

import com.mapper.CardetailMapper;
import com.pojo.Cardetail;
import com.service.CardetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardetailServiceImpl implements CardetailService {

    @Autowired
    private CardetailMapper cardetailMapper;

    @Override
    public List<Cardetail> getAll() {
        return cardetailMapper.selectWithTranscarPaidtypeUsersByExample(null);
    }

    @Override
    public List<Cardetail> getCardetail(Integer customerid) {
        return cardetailMapper.selectWithTranscarPaidtypeUsersByCoustomerId(customerid);
    }

    @Override
    public List<Cardetail> getCardetailByQuery(Cardetail cardetail) {
        return cardetailMapper.selectWithTranscarPaidtypeUsersByQuery(cardetail);
    }


}
