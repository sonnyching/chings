package com.chings.core.exception;

/**
 * Created by sonnyching on 2017/7/18.
 */
public class DBException extends AbsException {

    public DBException(String message) {
        super(message);
        setCode(700);
    }
}
