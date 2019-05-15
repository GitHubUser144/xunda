package com.service.impl;

import com.mapper.CustomertypeMapper;
import com.pojo.Customertype;
import com.service.CustomertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomertypeServiceImpl implements CustomertypeService {

    @Autowired
    private CustomertypeMapper customertypeMapper;

    @Override
    public List<Customertype> getAll() {
        return customertypeMapper.selectByExample(null);
    }
}
