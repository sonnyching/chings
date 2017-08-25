package com.chings.core.utils;

/**
 * Created by sonnyching on 2017/7/12.
 */
public class Constant {

    public static final String PRE_LOGIN = "login_user_";//存储登陆所用前缀

    public static final int MESSAGE_TYPE_ARTICLE = 1;

    public static final String ACTION_TYPE_ARTICLE = "likes";

    /**
     * 动作类型，针对于目标对象而言
     */
    public class ActionType{
        /**
         * 喜欢
         */
        public static final String LIKE = "likes";
        /**
         * 评论
         */
        public static final String COMMENT = "comment";
        /**
         * 更新
         */
        public static final String UPDATE = "update";

    }

    public class TargetType{
        /**
         * 文章
         */
        public static final int ARTICLE = 1;
        /**
         * 评论
         */
        public static final int COMMENT = 2;
        /**
         * 公告
         */
        public static final int ANNOUNCE = 3;

    }


    /**
     * 用户操作事件类型
     */
    public enum UserEventType{
        login,logout,submit
    }

}
