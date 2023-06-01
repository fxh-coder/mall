package com.imooc.imoocmall.service;

import com.imooc.imoocmall.exception.ImoocMallException;
import com.imooc.imoocmall.model.pojo.User;

public interface UserService {
    User getUser();

    void register(String userName, String password);

    User login(String userName, String password) throws ImoocMallException;

    void updateInformation(User user) throws ImoocMallException;

    boolean checkAdminRole(User user);
}
