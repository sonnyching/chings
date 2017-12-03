package com.chings.core.config;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sonnyching on 2017/12/3.
 */
public class ConfigReader {

    public static String getConfig(String filePath,String name){

        InputStream in = Constant.class.getClassLoader().getResourceAsStream(filePath);

        Properties properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        String value = properties.getProperty(name);

        IOUtils.closeQuietly(in);

        return value;
    }


    public static Properties getConfig(String filePath){

        InputStream in = Constant.class.getClassLoader().getResourceAsStream(filePath);

        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return properties;
    }

    public static void main(String args[]){
    }

}
