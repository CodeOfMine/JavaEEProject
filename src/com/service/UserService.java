package com.service;

import com.domain.User;

import java.util.List;

public interface UserService {
    //注册用户方法
    public void registerUser(User user);
    //用户登陆方法
    public User loginUser(String username, String password);
    //根据用户名查询userid的方法
    public Integer getUserIdByName(String username);
}
