package com.service;

import com.domain.Message;

import java.util.List;

public interface MessageService {
    //将留言保存到数据库的方法
    public void saveMessage(Message message,String username);
    //修改留言方法
    public void modifyMessage(Message message,String oldTopic);
    //根据留言标题查id的方法
    public Integer getMessageByTopic(String oldTopic,Integer userId);
    //查询所有留言的方法
    public List<Message> getAllMessage();

}
