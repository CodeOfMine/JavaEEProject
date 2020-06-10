package com.domain;


//留言类
public class Message {
    //留言ID
    private Integer messageId;
    //留言标题
    private String topic;
    //留言内容
    private String content;
    //留言时间
    private String time;
    //发表评论的用户
    private Integer userId;
    //发表评论用户的名字
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
