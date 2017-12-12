package com.chings.core.utils;

import org.apache.log4j.Logger;

/**
 * Created by sonnyching on 2017/8/22.
 */
public class Log {

    public static void info(Object message){
        Logger logger = Logger.getLogger("");
        logger.info(message);
    }

    public static void debug(Object message){
        Logger logger = Logger.getLogger("");
        logger.debug(message);
    }

    private Log(){

    }

}
