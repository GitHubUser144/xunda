package com.service.impl;

import com.mapper.TranscarMapper;
import com.pojo.Transcar;
import com.pojo.TranscarExample;
import com.service.TranscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranscarServiceImpl implements TranscarService {

    @Autowired
    private TranscarMapper transcarMapper;

    @Override
    public List<Transcar> getAllTransCar() {
        return transcarMapper.selectWithCarSendTypeByExample(null);
    }

    @Override
    public Transcar getTransCarByTransId(Integer tradsid) {
        return transcarMapper.selectWithCarSendTypeByPrimaryKey(tradsid);
    }

    @Override
    public List<Transcar> getTransCarByCarStatus(String status) {
        TranscarExample transcarExample = new TranscarExample();
        TranscarExample.Criteria criteria = transcarExample.createCriteria();
        criteria.andCarstatusEqualTo(status);
        return transcarMapper.selectWithCarSendTypeByExample(transcarExample);
    }

    @Override
    public void updateTranscarStatusByTransId(Integer transid,String status) {
        Transcar transcar = new Transcar();
        transcar.setCarstatus(status);
        TranscarExample transcarExample = new TranscarExample();
        TranscarExample.Criteria criteria = transcarExample.createCriteria();
        criteria.andTransidEqualTo(transid);
        transcarMapper.updateByExampleSelective(transcar,transcarExample);
    }

    @Override
    public void updateTranscar(Transcar transcar) {
        TranscarExample transcarExample = new TranscarExample();
        TranscarExample.Criteria criteria = transcarExample.createCriteria();
        criteria.andTransidEqualTo(transcar.getTransid());
        transcarMapper.updateByExampleSelective(transcar,transcarExample);
    }

    @Override
    public void save(Transcar transcar) {
        transcarMapper.insertSelective(transcar);
    }

    @Override
    public Long getCount() {
        return transcarMapper.countByExample(null);
    }
}
