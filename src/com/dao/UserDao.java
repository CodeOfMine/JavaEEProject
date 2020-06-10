package com.dao;

import com.domain.User;

import java.util.List;

//处理用户操作的接口
public interface UserDao {
    //注册用户的方法
    public void registerUser(User user);
    //登陆方法
    public User loginUser(String username, String password);
    //根据用户名查询userid的方法
    public Integer getUserIdByName(String username);

}
