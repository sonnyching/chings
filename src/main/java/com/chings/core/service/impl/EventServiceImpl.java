package com.chings.core.service.impl;

import com.chings.core.dao.IEventDao;
import com.chings.core.exception.SystemException;
import com.chings.core.model.UserEvent;
import com.chings.core.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by sonnyching on 2017/8/24.
 */
@Service
public class EventServiceImpl implements IEventService {

    @Autowired
    IEventDao eventDao;

    @Override
    public int addEvent(long userId,int eventType,String message) {

        int result = 0;
        try {
            UserEvent event = new UserEvent(new Date(),userId,eventType,message);
            result =  eventDao.addEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
            //不影响主业务，直接吞掉异常
            //throw new SystemException("保存失败");
        }

        return result;
    }
}
