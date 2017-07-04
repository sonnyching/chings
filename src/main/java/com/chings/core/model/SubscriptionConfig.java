package com.chings.core.model;

/**
 * 用户订阅的事件类型
 * Created by sonnyching on 2017/7/5.
 */
public class SubscriptionConfig {

    public long id;

    /**订阅的事件类型**/
    public String action;

    /**订阅人**/
    public long userId;

    public SubscriptionConfig(long id, String action, long userId) {
        this.id = id;
        this.action = action;
        this.userId = userId;
    }

    public SubscriptionConfig() {
    }

    public long getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public long getUserId() {
        return userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
