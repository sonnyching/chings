package com.chings.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sonnyching on 2017/8/22.
 */
public class DateUtil {

    public static String getNowDate(String pattern){

        SimpleDateFormat format = new SimpleDateFormat(pattern);

        return format.format(new Date()).toString();

    }


}
