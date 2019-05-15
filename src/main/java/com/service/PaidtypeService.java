package com.service;

import com.pojo.Paidtype;

import java.util.List;

/**
 * 付款方式的业务层
 */
public interface PaidtypeService {

    /**
     * 查询所有的付款方式
     * @return
     */
    List<Paidtype> getAll();

    /**
     * 添加付款方式
     * @param paidtype
     */
    void save(Paidtype paidtype);

    /**
     * 获取记录数
     * @return
     */
    long getCount();

    /**
     * 根据id查询付款方式
     * @param paidid
     * @return
     */
    Paidtype getPaidTypeById(Integer paidid);

    /**
     * 更新付款方式
     * @param paidtype
     */
    void update(Paidtype paidtype);

    /**
     * 删除付款方式
     * @param pn
     */
    void delete(Integer paidid);
}
