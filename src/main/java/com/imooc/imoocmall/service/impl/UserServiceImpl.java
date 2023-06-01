package com.imooc.imoocmall.service.impl;

import com.imooc.imoocmall.model.dao.UserMapper;
import com.imooc.imoocmall.model.pojo.User;
import com.imooc.imoocmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }
}
