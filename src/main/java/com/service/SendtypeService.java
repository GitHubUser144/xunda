package com.service;

import com.pojo.Sendtype;

import java.util.List;

/**
 * 车辆类型的业务层
 */
public interface SendtypeService {


    /**
     * 查询所有
     * @return
     */
    List<Sendtype> getAll();

    /**
     * 添加运输工具
     * @param sendtype
     */
    void save(Sendtype sendtype);

    /**
     * 获取记录数
     * @return
     */
    long getCount();

    /**
     * 根据id查询运输工具
     * @param sendtypeid
     * @return
     */
    Sendtype getSendTypeById(Integer sendtypeid);

    /**
     * 更新运输工具
     * @param sendtype
     */
    void update(Sendtype sendtype);

    /**
     * 删除运输工具
     * @param sendtypeid
     */
    void deleteSendType(Integer sendtypeid);
}
