package com.chings.core.dao;

import com.chings.core.model.SubscriptionConfig;
import com.chings.core.model.User;
import com.chings.core.model.UserMessage;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IMessageDao {

    public int createAnnounce(String content,User sender);
    public int createRemind(@Param(value="target")long target,
                            @Param(value="targetType")int targetType,
                            @Param(value="messageType")int messageType,
                            @Param(value="action")String action,
                            @Param(value="senderId")long senderId,
                            @Param(value="content")String content,
                            @Param(value="createTime")Date createTime);
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
