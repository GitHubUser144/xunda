package com.service.impl;

import com.mapper.OrderstatusMapper;
import com.pojo.Orderstatus;
import com.service.OrderstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderstatusServiceImpl implements OrderstatusService {

    @Autowired
    private OrderstatusMapper orderstatusMapper;

    @Override
    public List<Orderstatus> getAll() {
        return orderstatusMapper.selectByExample(null);
    }

    @Override
    public void save(Orderstatus orderstatus) {
        orderstatusMapper.insertSelective(orderstatus);
    }

    @Override
    public long getCount() {
        return orderstatusMapper.countByExample(null);
    }

    @Override
    public Orderstatus getOrderStatusById(Integer orderid) {
        return orderstatusMapper.selectByPrimaryKey(orderid);
    }

    @Override
    public void update(Orderstatus orderstatus) {
        orderstatusMapper.updateByPrimaryKeySelective(orderstatus);
    }

    @Override
    public void delete(Integer orderid) {
        orderstatusMapper.deleteByPrimaryKey(orderid);
    }
}
