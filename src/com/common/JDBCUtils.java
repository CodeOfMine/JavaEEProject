package com.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//数据库连接公共类
public class JDBCUtils {
    private static DataSource dataSource;

    static {
        try {
            //加载数据库配置文件
            Properties prop = new Properties();
            //使用ClassLoader加载配置文件 获取字节输入流
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(in);
            //初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象的方法
    public static DataSource getDataSource() {
        return dataSource;
    }
    //获取Connection对象的方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
