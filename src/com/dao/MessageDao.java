package com.dao;

import com.domain.Message;

import java.util.List;

public interface MessageDao {
    //执行插入留言的方法
    public void saveMessage(Message message,String username);
    //修改留言的方法
    public void modifyMessage(Message message,String oldTopic);
    //根据留言标题查询id的方法
    public Integer getMessageByTopic(String oldTopic,Integer userId);
    //查询所有留言的方法
    public List<Message> getAllMessage();
}
