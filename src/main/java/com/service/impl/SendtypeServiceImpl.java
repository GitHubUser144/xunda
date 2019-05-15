package com.service.impl;

import com.mapper.SendtypeMapper;
import com.pojo.Sendtype;
import com.service.SendtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendtypeServiceImpl implements SendtypeService {

    @Autowired
    private SendtypeMapper sendtypeMapper;

    @Override
    public List<Sendtype> getAll() {
        return sendtypeMapper.selectByExample(null);
    }

    @Override
    public void save(Sendtype sendtype) {
        sendtypeMapper.insertSelective(sendtype);
    }

    @Override
    public long getCount() {
        return sendtypeMapper.countByExample(null);
    }

    @Override
    public Sendtype getSendTypeById(Integer sendtypeid) {
        return sendtypeMapper.selectByPrimaryKey(sendtypeid);
    }

    @Override
    public void update(Sendtype sendtype) {
        sendtypeMapper.updateByPrimaryKeySelective(sendtype);
    }

    @Override
    public void deleteSendType(Integer sendtypeid) {
        sendtypeMapper.deleteByPrimaryKey(sendtypeid);
    }
}
