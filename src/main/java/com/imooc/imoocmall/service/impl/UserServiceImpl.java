package com.imooc.imoocmall.service.impl;

import com.imooc.imoocmall.exception.ImoocMallException;
import com.imooc.imoocmall.exception.ImoocMallExceptionEnum;
import com.imooc.imoocmall.model.dao.UserMapper;
import com.imooc.imoocmall.model.pojo.User;
import com.imooc.imoocmall.service.UserService;
import com.imooc.imoocmall.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public void register(String userName, String password) {
        // 查询用户名是否存在，不允许重名
        User result = userMapper.selectByName(userName);
        if (result != null) {
            throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTD);
        }
        // 将信息写到数据库
        User user = new User();
        user.setUsername(userName);
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // 这个方法只会给两个字段赋值
        int count = userMapper.insertSelective(user);
        // 成功返回count为1失败返回count为0
        if (count == 0) {
            throw new ImoocMallException(ImoocMallExceptionEnum.INSERT_FAILED);
        }
    }
}
