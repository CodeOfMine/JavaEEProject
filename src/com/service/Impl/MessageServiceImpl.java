package com.service.Impl;

import com.dao.Impl.MessageDaoImpl;
import com.dao.MessageDao;
import com.domain.Message;
import com.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    //创建MessageDao对象 并调用相应的方法
    private MessageDao messageDao = new MessageDaoImpl();
    @Override
    public void saveMessage(Message message,String username) {
        //调用messageDao的保存留言方法 实现将留言保存到数据库中
        messageDao.saveMessage(message,username);
    }

    @Override
    public void modifyMessage(Message message,String oldTopic) {
        //调用dao层的修改方法
        messageDao.modifyMessage(message,oldTopic);
    }

    @Override
    public Integer getMessageByTopic(String oldTopic,Integer userId) {
        //调用dao层的查询方法并返回
        return messageDao.getMessageByTopic(oldTopic,userId);
    }

    @Override
    public List<Message> getAllMessage() {
        //调用dao层的查询方法并返回集合
        return messageDao.getAllMessage();
    }

}
