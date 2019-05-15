package com.service.impl;

import com.mapper.AccmoduleMapper;
import com.pojo.Accmodule;
import com.pojo.AccmoduleExample;
import com.service.AccmoduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccmoduleServiceImpl implements AccmoduleService {

    @Autowired
    private AccmoduleMapper accmoduleMapper;

    @Override
    public List<Accmodule> getAccmoduleByUserId(Integer id) {
        return accmoduleMapper.selectWithModuleByUserid(id);
    }

    @Override
    public void save(Accmodule accmodule) {
        accmoduleMapper.insertSelective(accmodule);
    }

    @Override
    public void deleteByModuleid(AccmoduleExample accmoduleExample) {
        accmoduleMapper.deleteByExample(accmoduleExample);
    }
}
