package com.chings.core.exception;

/**
 * 用户已存在
 * Created by sonnyching on 2017/7/15.
 */
public class UserExistException extends AbsException{

    public UserExistException(String message) {
        super(message);
        setMsg(message);
        this.code = 101;
    }
}
