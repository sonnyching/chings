package com.chings.core.model;

import java.util.Date;

/**
 * 用户订阅的事件
 * Created by sonnyching on 2017/7/5.
 */
public class Subscription {

    public long id;

    /**订阅人**/
    public long userId;

    /**订阅的事件类型(like喜欢,comment评论,post私信，update更新)**/
    public String action;

    /**订阅对象类型**/
    public int targetType;

    /**订阅对象id**/
    public long tartget;

    public Date createTime;

    public Subscription() {
    }

    public Subscription(long id, long userId, String action, int targetType, long tartget, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.action = action;
        this.targetType = targetType;
        this.tartget = tartget;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }

    public int getTargetType() {
        return targetType;
    }

    public long getTartget() {
        return tartget;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public void setTartget(long tartget) {
        this.tartget = tartget;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
