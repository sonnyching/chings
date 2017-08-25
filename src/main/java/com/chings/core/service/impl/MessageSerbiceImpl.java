package com.chings.core.service.impl;

import com.chings.core.dao.IMessageDao;
import com.chings.core.exception.DBException;
import com.chings.core.exception.ParamException;
import com.chings.core.model.Subscription;
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
    public int createMessage(String content, long sender, User receiver) {
        return 0;
    }

    @Override
    public List<UserMessage> pullAnnounce(long user) {
        return null;
    }

    @Override
    public List<UserMessage> pullRemind(long user) {
        return null;
    }

    @Override
    public int subscribe(long userId,List<Subscription> subscriptions){
       if(subscriptions==null || subscriptions.size()<=0){
           return -1;
       }
        for (Subscription sub :subscriptions) {
            int result = this.subscribe(userId,sub.tartget,sub.targetType,sub.action);
            if(result < 1){
                throw new DBException("保存失败");
            }
        }

       return 1;
    }

    private int subscribe(long user, long target, int targetType, String actions) {

        if(user<=0){
            throw new ParamException("用户id为空");
        }

        return messageDao.subscribe(user,target,targetType,actions);
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

        //先找出用户订阅了哪些消息
        List<Subscription> subscriptions = messageDao.querySubScribe(userId);

        if(subscriptions==null || subscriptions.size()<=0){
            return null;
        }

        //针对每种类型的消息去查询message表
//        messageDao.queryMessages


        return null;
    }

    @Override
    public int read(User user, long messageActionId) {
        return 0;
    }
}
