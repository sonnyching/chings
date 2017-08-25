package com.chings.core.service;

import com.chings.core.model.Subscription;
import com.chings.core.model.SubscriptionConfig;
import com.chings.core.model.User;
import com.chings.core.model.UserMessage;

import java.util.List;

/**
 * Created by sonnyching on 2017/7/5.
 */
public interface IMessageService {

    public int createAnnounce(String content,User sender);
    public int createRemind(long target,int targetType,int messageType ,String action,long senderId,String content);
    public int createMessage(String content,long sender,User receiver);
    public List<UserMessage> pullAnnounce(long user);
    public List<UserMessage> pullRemind(long user);
    public int subscribe(long userId,List<Subscription> subscriptions);
    public int cancelSubscription(long userId, long target ,int targetType);
    public List<SubscriptionConfig> getSubscriptionConfig(long userId);
    public int updateSubscriptionConfig(long userId);
    public List<UserMessage> getUserNotify(long userId);
    public int read(User user, long messageActionId);


}
