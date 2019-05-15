package com.service;

import com.pojo.Users;

import java.util.List;

/**
 * 用户业务层接口
 */
public interface UsersService {

    /**
     *
     * @param userName 用户名
     * @param password 密码
     * @return 如果存在返回Users对象 不存在返回null
     */
    public Users getUserByNmaeAndPw(String userName,String password);

    /**
     * 获取所有的用户
     * @return 用户集合
     */
    public List<Users> getAllUser();

    /**
     * 添加用户
     * @param users 用户对象
     */
    public void save(Users users);

    /**
     * 根据用户Id查询用户
     * @param id 用户id
     */
    public Users getUserById(Integer id);

    /**
     * 修改用户
     * @param users
     */
    public void updateUser(Users users);

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(Integer id);

    /**
     * 统计有多少条记录
     * @return
     */
    public long getUserCount();

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    Users getUserByName(String username);

    /**
     * 修改用户的状态
     * @param id
     * @param staus
     */
    public void updateUserStaus(int id, int staus);

    /**
     * 更新用户的密码
     * @param id
     * @param password
     */
    public void updateUserPassword(Integer id, String password);
}
