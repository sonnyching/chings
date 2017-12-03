package com.chings.core.service;

/**
 * Created by sonnyching on 2017/12/3.
 */
public interface ISupervisorService {

    /**
     * 备份数据库
     * @param path 备份地址
     * @return
     */
    public boolean makeBdBackup(String path);

    /**
     *备份静态资源
     * @param backupPath 备份地址
     * @return
     */
    public boolean staticsBackup(String targetpath,String backupPath);

}
