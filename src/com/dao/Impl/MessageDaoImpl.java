package com.dao.Impl;

import com.common.JDBCUtils;
import com.dao.MessageDao;
import com.domain.Message;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class MessageDaoImpl implements MessageDao {

    //创建Jdbctemplate对象
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void saveMessage(Message message,String username) {
        //操作数据库 将留言保存到数据库中
        //创建插入语句
        String sql = "insert into message(topic,content,time,userId,username) values(?,?,?,?,?)";
        try {
            //执行插入语句
            jdbcTemplate.update(sql, message.getTopic(), message.getContent(), message.getTime(), message.getUserId(),username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyMessage(Message message, String oldTopic) {
        //创建修改的sql语句
        String sql = "update message set topic = ?,content = ?,time = ? where topic = ?";
        try {
            jdbcTemplate.update(sql, message.getTopic(), message.getContent(), message.getTime(), oldTopic);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Integer getMessageByTopic(String oldTopic, Integer userId) {
        //创建查询的sql语句
        String sql = "select messageId from message where topic = ? and userId = ?";
        try {
            //调用jdbctemplate对象的方法执行语句
            Integer messageId = jdbcTemplate.queryForObject(sql, new Object[]{oldTopic, userId}, Integer.class);
            System.out.println(messageId);
            return messageId;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Message> getAllMessage() {
        //创建查询语句
        String sql = "select * from message";
        //调用jdbctemplate对象的方法执行语句
        List<Message> messages = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Message>(Message.class));
        return messages;
    }

}
