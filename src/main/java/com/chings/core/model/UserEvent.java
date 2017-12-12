package com.chings.core.model;

import java.util.Date;

/**
 * 用户操作记录表
 * Created by sonnyching on 2017/8/22.
 */
public class UserEvent {
    public long id;
    public Date time;
    public long userId;
    public int eventType;
    public String message;

    public UserEvent(Date time, long userId, int eventType, String message) {
        this.time = time;
        this.userId = userId;
        this.eventType = eventType;
        this.message = message;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public long getUserId() {
        return userId;
    }

    public int getEventType() {
        return eventType;
    }

    public String getMessage() {
        return message;
    }
}
