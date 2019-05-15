package com.service;

import com.pojo.Module;

import java.util.List;


public interface ModuleService {
    /**
     * 获取所有的权限
     * @return
     */
    List<Module> getAll();
}
