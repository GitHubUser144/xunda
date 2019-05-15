package com.service;

import com.pojo.Balance;
import com.pojo.BalanceExample;
import com.pojo.BalanceQuery;

import java.util.List;

/**
 * 客户账目往来明细的业务层
 */
public interface BalanceService {

    /**
     * 根据客户的id查询客户的账单
     *
     * @param customerid
     */
    List<Balance> getBalanceById(Integer customerid);

    /**
     * 查询所有的客户的账单
     * @return
     */
    List<Balance> getAll();

    /**
     * 根据条件查询
     * @param balanceQuery
     * @return
     */
    List<Balance> getBalanceByQuery(BalanceQuery balanceQuery);

    /**
     * 添加账目
     */
    void save(Balance balance);

    /**
     * 查询总记录数
     * @return
     */
    long getCount();

    /**
     * 作废
     * @param balance
     * @param balanceExample
     */
    void updateBalanceWithinvalid(Balance balance, BalanceExample balanceExample);
}
