package com.chings.core.exception;

/**
 * 系统异常
 * Created by sonnyching on 2017/7/11.
 */
public class SystemException extends AbsException{

    public SystemException(int code, String message) {
        super(code, message);
    }
}
