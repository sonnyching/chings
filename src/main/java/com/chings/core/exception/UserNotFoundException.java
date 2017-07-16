package com.chings.core.exception;

/**
 * 找不到用户异常
 * Created by sonnyching on 2017/7/11.
 */
public class UserNotFoundException extends AbsException {

    public UserNotFoundException(String message) {
        super(message);this.code=101;
        setMsg(message);
    }

}
