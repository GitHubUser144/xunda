package com.service.impl;

import com.mapper.CarroadMapper;
import com.pojo.Carroad;
import com.pojo.CarroadExample;
import com.service.CarroadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroadServiceImpl implements CarroadService {

    @Autowired
    private CarroadMapper carroadMapper;

    @Override
    public List<Carroad> getCarroadById(Integer transid) {
        CarroadExample carroadExample = new CarroadExample();
        CarroadExample.Criteria criteria = carroadExample.createCriteria();
        criteria.andTransidEqualTo(transid);
        return carroadMapper.selectByExample(carroadExample);
    }
}
