package com.service.impl;

import com.mapper.AreaMapper;
import com.pojo.Area;
import com.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 区域业务层实现类
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAllArea() {
        return areaMapper.selectByExample(null);
    }

    @Override
    public Area getAreaById(Integer rececity) {
        return areaMapper.selectByPrimaryKey(rececity);
    }

    @Override
    public void save(Area area) {
        areaMapper.insertSelective(area);
    }

    @Override
    public Long getCount() {
        return areaMapper.countByExample(null);
    }

    @Override
    public void update(Area area) {
        areaMapper.updateByPrimaryKeySelective(area);
    }

    @Override
    public void delete(Integer areaid) {
        areaMapper.deleteByPrimaryKey(areaid);
    }
}
