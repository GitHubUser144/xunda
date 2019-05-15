package com.service;

import com.pojo.Accmodule;
import com.pojo.AccmoduleExample;

import java.util.List;

/**
 *
 */
public interface AccmoduleService {

    /**
     * 根据用户id查询权限
     * @param id
     * @return
     */
    List<Accmodule> getAccmoduleByUserId(Integer id);

    /**
     * 授权
     * @param accmodule
     */
    void save(Accmodule accmodule);

    /**
     * 删除权限
     * @param accmoduleExample
     */
    void deleteByModuleid(AccmoduleExample accmoduleExample);
}
