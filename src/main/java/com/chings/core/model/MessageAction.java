package com.chings.core.model;

import java.util.Date;

/**
 * 消息事件-记录产生的消息事件
 * Created by sonnyching on 2017/7/5.
 */
public class MessageAction {

    /**消息id**/
    public long id;

    /**消息内容**/
    public String content;

    /**消息类型1: 公告 Announce，2: 提醒 Remind，3：信息 Message**/
    public int type;

    /**目标对象**/
    public long target;

    /**目标对象类型**/
    public int targetType;

    /**提醒动作类型**/
    public String action;

    /**消息生产者**/
    public long sender;

    /****/
    public Date createTime;

    public MessageAction() {

    }

    public MessageAction(long id, String content, int type,
                         long target, int targetType,
                         String action, long sender, Date createTime) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.target = target;
        this.targetType = targetType;
        this.action = action;
        this.sender = sender;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public long getTarget() {
        return target;
    }

    public int getTargetType() {
        return targetType;
    }

    public String getAction() {
        return action;
    }

    public long getSender() {
        return sender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTarget(long target) {
        this.target = target;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}


