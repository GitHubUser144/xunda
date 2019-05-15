package com.service;

import com.pojo.Customertype;

import java.util.List;

/**
 *  用户类型的业务层
 */
public interface CustomertypeService {
    /**
     * 查询所有的用户类型
     * @return
     */
    List<Customertype> getAll();
}
