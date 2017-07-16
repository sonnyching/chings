package com.chings.core.exception;

/**
 * Created by sonnyching on 2017/7/15.
 */
public class UserNotLogin extends AbsException{

    public UserNotLogin(String message) {
        super(message);
        setMsg(message);
        this.code = 100;
    }
}
