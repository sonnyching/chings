package com.chings.core.service;

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
    public int createMessage(String content,User sender,User receiver);
    public List<UserMessage> pullAnnounce(User user);
    public List<UserMessage> pullRemind(User user);
    public int subscribe(User user,long target,int targetType,String reason);
    public int cancelSubscription(long userId, long target ,int targetType);
    public List<SubscriptionConfig> getSubscriptionConfig(long userId);
    public int updateSubscriptionConfig(long userId);
    public List<UserMessage> getUserNotify(long userId);
    public int read(User user, long messageActionId);


}
