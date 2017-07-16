package com.chings.core.exception;

/**
 * 参数异常
 * Created by sonnyching on 2017/7/11.
 */
public class ParamException extends AbsException{
    public ParamException(String message) {
        super(message);
        setMsg(message);
        this.code = 300;
    }
}
