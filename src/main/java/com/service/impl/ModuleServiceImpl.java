package com.service.impl;

import com.mapper.ModuleMapper;
import com.pojo.Module;
import com.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public List<Module> getAll() {
        return moduleMapper.selectByExample(null);
    }
}
