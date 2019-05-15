package com.service;

import com.pojo.Area;

import java.util.List;

/**
 * 区域的业务层接口
 */
public interface AreaService {

    /**
     * 查询所有的地区
     * @return
     */
    public List<Area> getAllArea();

    /**
     * 根据id查询所属区域
     * @param rececity
     * @return
     */
    Area getAreaById(Integer rececity);

    /**
     * 添加区域
     * @param area
     */
    void save(Area area);

    /**
     * 统计有多少条记录
     * @return
     */
    Long getCount();

    /**
     * 更新区域
     * @param area
     */
    void update(Area area);

    /**
     * 删除
     * @param areaid
     */
    void delete(Integer areaid);
}
