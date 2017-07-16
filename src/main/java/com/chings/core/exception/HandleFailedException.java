package com.chings.core.exception;

/**
 * 处理、操作失败
 * Created by sonnyching on 2017/7/15.
 */
public class HandleFailedException extends AbsException{

    public HandleFailedException(String message) {
        super(message);
        setMsg(message);
        setCode(501);
    }
}
