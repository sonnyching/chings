package com.chings.core.service.impl;

import com.chings.core.dao.ISupervisorDao;
import com.chings.core.service.ISupervisorService;
import com.chings.core.utils.DateUtil;
import com.chings.core.utils.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by sonnyching on 2017/12/3.
 */
@Service
public class SupervisorServiceImpl implements ISupervisorService {

//    @Autowired
//    public ISupervisorDao supervisorDao;

    @Override
    public boolean makeBdBackup(String path) {

//        try {
//            return supervisorDao.makeBdBackup(path);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return false;
    }

    @Override
    public boolean staticsBackup(String targetpath,String backupPath){

        String now = DateUtil.getNowDate("yyyyMMdd");
        String timeMills = DateUtil.getNowDate("hhMMss");

        File fileDir = new File(backupPath + "/" + now + "/" + timeMills);

        if(!fileDir.exists()){
            if(!fileDir.mkdirs()){
                Log.info("创建备份文件夹失败");
                return false;
            }
        }

        try {
            FileUtils.copyDirectory(new File(targetpath),fileDir);
        } catch (IOException e) {
            Log.info("复制文件失败:"+e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
