package com.chings.core.utils;

import com.chings.core.exception.AbsException;
import net.sf.json.JSONObject;

/**
 * Created by sonnyching on 2017/7/15.
 */
public class ResponseUtils {

    public static JSONObject responseJosn(Exception e){
        if(e instanceof AbsException){
            AbsException e2 = (AbsException)e;
            return getString(e2.getCode(),e2.getMsg());
        }
        return getString(-1,e.getMessage());
    }

    private static JSONObject getString(int code,String msg){
        JSONObject obj = new JSONObject();
        obj.put("code",code);
        obj.put("msg",msg);
        return obj;
    }

}
