package com.zs.tmall.service.impl;

import com.zs.tmall.mapper.UserMapper;
import com.zs.tmall.pojo.User;
import com.zs.tmall.pojo.UserExample;
import com.zs.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 98050
 * Time: 2018-09-20 10:53
 * Feature:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public boolean isExist(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public User get(String name, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
}
