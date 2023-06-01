package com.imooc.imoocmall.service;

import com.imooc.imoocmall.model.pojo.User;

public interface UserService {
    User getUser();

    void register(String userName, String password);
}
