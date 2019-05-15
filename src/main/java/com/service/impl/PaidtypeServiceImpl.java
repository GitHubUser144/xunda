package com.service.impl;

import com.mapper.PaidtypeMapper;
import com.pojo.Paidtype;
import com.service.PaidtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaidtypeServiceImpl implements PaidtypeService {

    @Autowired
    private PaidtypeMapper paidtypeMapper;

    @Override
    public List<Paidtype> getAll() {
        return paidtypeMapper.selectByExample(null);
    }

    @Override
    public void save(Paidtype paidtype) {
        paidtypeMapper.insertSelective(paidtype);
    }

    @Override
    public long getCount() {
        return paidtypeMapper.countByExample(null);
    }

    @Override
    public Paidtype getPaidTypeById(Integer paidid) {
        return paidtypeMapper.selectByPrimaryKey(paidid);
    }

    @Override
    public void update(Paidtype paidtype) {
        paidtypeMapper.updateByPrimaryKeySelective(paidtype);
    }

    @Override
    public void delete(Integer paidid) {
        paidtypeMapper.deleteByPrimaryKey(paidid);
    }
}
