package com.service.impl;

import com.mapper.BalanceMapper;
import com.pojo.Balance;
import com.pojo.BalanceExample;
import com.pojo.BalanceQuery;
import com.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceMapper balanceMapper;

    @Override
    public List<Balance> getBalanceById(Integer customerid) {
        return balanceMapper.selectWithCustomerUserByExample(customerid);
    }

    @Override
    public List<Balance> getAll() {
        return balanceMapper.selectWithCustomerUser(null);
    }

    @Override
    public List<Balance> getBalanceByQuery(BalanceQuery balanceQuery) {
        return balanceMapper.selectWithCustomerUserByQuery(balanceQuery);
    }

    @Override
    public void save(Balance balance) {
        balanceMapper.insertSelective(balance);
    }

    @Override
    public long getCount() {
        return balanceMapper.countByExample(null);
    }

    @Override
    public void updateBalanceWithinvalid(Balance balance, BalanceExample balanceExample) {
        balanceMapper.updateByExampleSelective(balance,balanceExample);
    }


}
