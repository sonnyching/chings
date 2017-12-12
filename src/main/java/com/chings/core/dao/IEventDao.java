package com.chings.core.dao;

import com.chings.core.model.UserEvent;

/**
 * Created by sonnyching on 2017/8/24.
 */
public interface IEventDao {

    /**
     * 添加事件
     * @return
     */
    public int addEvent(UserEvent event);


}
