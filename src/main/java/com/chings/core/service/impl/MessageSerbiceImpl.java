package com.chings.core.service.impl;

import com.chings.core.dao.IMessageDao;
import com.chings.core.model.SubscriptionConfig;
import com.chings.core.model.User;
import com.chings.core.model.UserMessage;
import com.chings.core.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by sonnyching on 2017/7/5.
 */
@Service
public class MessageSerbiceImpl implements IMessageService{

    @Autowired
    private IMessageDao messageDao;

    @Override
    public int createAnnounce(String content, User sender) {
        return 0;
    }

    @Override
    @Transactional
    public int createRemind(long target, int targetType,int messageType ,String action, long senderId, String content) {

        int rows = 0;
        try{
           rows = messageDao.createRemind(target,targetType,messageType,action,senderId,content,new Date());
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int createMessage(String content, User sender, User receiver) {
        return 0;
    }

    @Override
    public List<UserMessage> pullAnnounce(User user) {
        return null;
    }

    @Override
    public List<UserMessage> pullRemind(User user) {
        return null;
    }

    @Override
    public int subscribe(User user, long target, int targetType, String reason) {
        return 0;
    }

    @Override
    public int cancelSubscription(long userId, long target, int targetType) {
        return 0;
    }

    @Override
    public List<SubscriptionConfig> getSubscriptionConfig(long userId) {
        return null;
    }

    @Override
    public int updateSubscriptionConfig(long userId) {
        return 0;
    }

    @Override
    public List<UserMessage> getUserNotify(long userId) {
        return null;
    }

    @Override
    public int read(User user, long messageActionId) {
        return 0;
    }
}
