package com.service.Impl;

import com.dao.Impl.UserDaoImpl;
import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;



public class UserServieImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        //调用dao完成操作
        userDao.registerUser(user);
    }

    @Override
    public User loginUser(String username, String password) {
        //调用dao完成操作
        return userDao.loginUser(username,password);
    }

    @Override
    public Integer getUserIdByName(String username) {
        return userDao.getUserIdByName(username);
    }

}
