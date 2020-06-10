package com.dao.Impl;

import com.common.JDBCUtils;
import com.dao.UserDao;
import com.domain.User;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



public class UserDaoImpl implements UserDao {
    //创建Jdbctemplate对象
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void registerUser(User user) {
        //操作数据库
        //创建插入sql语句
        String sql = "insert into users (username,age,gender,password) values(?,?,?,?)";
        try {
            jdbcTemplate.update(sql,user.getUsername(),user.getAge(),user.getGender(),user.getPassword());
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User loginUser(String username, String password) {
        //操作数据库
        try {
            //创建查询语句
            String sql = "select * from users where username = ? and password = ?";
            //调用jdbctemplate对象的方法执行语句并返回对象
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
            return user;
        }catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer getUserIdByName(String username) {
        //操作数据库
        //创建查询语句
        String sql = "select userId from users where username = ?";
        try {
            //调用jdbctamplate对象的方法执行查询语句并返回结果
            Integer userId = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
            return userId;
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
