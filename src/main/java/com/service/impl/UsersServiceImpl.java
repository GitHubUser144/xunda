package com.service.impl;

import com.mapper.UsersMapper;
import com.pojo.Users;
import com.pojo.UsersExample;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层实现类
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users getUserByNmaeAndPw(String userName, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        List<Users> users = usersMapper.selectByExample(usersExample);
        if(users.size()>0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<Users> getAllUser() {
        return usersMapper.selectByExample(null);
    }

    @Override
    public void save(Users users) {
        usersMapper.insertSelective(users);
    }

    @Override
    public Users getUserById(Integer id) {
       return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(Users users) {
        usersMapper.updateByPrimaryKeySelective(users);
    }

    @Override
    public void deleteUser(Integer id) {
        usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long getUserCount() {
        return usersMapper.countByExample(null);
    }

    @Override
    public Users getUserByName(String username) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        if(usersList.size()>0){
            return usersList.get(0);
        }
        return null;
    }

    @Override
    public void updateUserStaus(int id, int staus) {
        Users users = new Users();
        users.setStaus(staus == 1 ? 0 : 1 );
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIdEqualTo(id);
        usersMapper.updateByExampleSelective(users,usersExample);
    }

    @Override
    public void updateUserPassword(Integer id, String password) {
        Users users = new Users();
        users.setPassword(password);
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIdEqualTo(id);
        usersMapper.updateByExampleSelective(users,usersExample);
    }
}
