package com.chings.core.exception;

/**
 * Created by sonnyching on 2017/7/15.
 */
public class HandleSuccessException extends AbsException {
    public HandleSuccessException(String message) {
        super(message);
        setMsg(message);
        setCode(0);
    }
}
