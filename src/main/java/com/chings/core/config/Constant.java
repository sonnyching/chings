package com.chings.core.config;

/**
 * Created by sonnyching on 2017/12/3.
 */
public class Constant {

    private static final String configFilePath = "config.properties";

//    public static final String dbBackupPath = ConfigReader.getConfig(configFilePath,"dbBackupPath");

    public static final String uploadBackupPath = ConfigReader.getConfig(configFilePath,"uploadBackupPath");
    public static final String uploadPath = ConfigReader.getConfig(configFilePath,"uploadPath");

    public static final boolean checklogin = Boolean.valueOf(ConfigReader.getConfig(configFilePath,"checklogin"));

//    public static final String projectStaticsDir = "/";

}
