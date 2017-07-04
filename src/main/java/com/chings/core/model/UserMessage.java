package com.chings.core.model;

import java.util.Date;

/**
 * 用户消息表-记录某个用户订阅并分发到的消息
 * Created by sonnyching on 2017/7/5.
 */
public class UserMessage {

    /**id**/
    public long id;

    /**是否阅读**/
    public boolean isRead;

    /**从属的用户id**/
    public long userId;

    /**对应的消息事件id**/
    public long messageActionId;

    /**时间**/
    public Date createTime;


    public UserMessage() {
    }

    public UserMessage(long id, boolean isRead, long userId, long messageActionId, Date createTime) {
        this.id = id;
        this.isRead = isRead;
        this.userId = userId;
        this.messageActionId = messageActionId;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public boolean isRead() {
        return isRead;
    }

    public long getUserId() {
        return userId;
    }

    public long getMessageActionId() {
        return messageActionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setMessageActionId(long messageActionId) {
        this.messageActionId = messageActionId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
