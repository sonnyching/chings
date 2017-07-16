package com.chings.core.exception;

/**
 * 基础异常
 * Created by sonnyching on 2017/7/11.
 */
public abstract class AbsException extends RuntimeException{

    public int code = 0;
    public String msg = "";

    public AbsException(int code,String message) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public AbsException(String message) {
        super(message);
        this.msg = msg;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
