package com.domain;
//用户类
public class User {
    //用户ID
    private Integer userId;
    //用户名
    private String username;
    //用户年龄
    private Integer age;
    //用户性别
    private String gender;
    //用户密码
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
