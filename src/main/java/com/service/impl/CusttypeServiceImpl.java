package com.service.impl;

import com.mapper.CustomertypeMapper;
import com.pojo.Customertype;
import com.service.CusttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusttypeServiceImpl implements CusttypeService {

    @Autowired
    private CustomertypeMapper customertypeMapper;

    @Override
    public List<Customertype> getAll() {
        return customertypeMapper.selectByExample(null);
    }

    @Override
    public void save(Customertype customertype) {
        customertypeMapper.insertSelective(customertype);
    }

    @Override
    public long getCount() {
        return customertypeMapper.countByExample(null);
    }

    @Override
    public Customertype getCustTypeById(Integer customertypeid) {
        return customertypeMapper.selectByPrimaryKey(customertypeid);
    }

    @Override
    public void update(Customertype customertype) {
        customertypeMapper.updateByPrimaryKeySelective(customertype);
    }

    @Override
    public void delete(Integer customertypeid) {
        customertypeMapper.deleteByPrimaryKey(customertypeid);
    }
}
