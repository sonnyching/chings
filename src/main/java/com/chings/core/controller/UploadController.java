package com.chings.core.controller;

import com.chings.core.conpont.AbstractController;
import com.chings.core.utils.DateUtil;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by sonnyching on 2017/9/11.
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends AbstractController {

    @RequestMapping("/image")
    @ResponseBody
    public JSONObject uploadImage(MultipartFile image, HttpServletRequest request){
        if(image==null){
            return createJSONObject(-1,"未选中图片","");
        }

        String name = UUID.randomUUID().toString();
        String year = DateUtil.getNowDate("yyyy");
        String month = DateUtil.getNowDate("MM");
        String day = DateUtil.getNowDate("dd");
        String root = request.getSession().getServletContext().getRealPath("/");
        String path = "static/upload/articleImages/"+year+"/"+month+"/"+day+"/";
        File storeFile = new File(root+path+name);
        try {
            if(storeFile.getParentFile() == null || !storeFile.getParentFile().exists()){
                new File(root+path).mkdirs();
                storeFile.createNewFile();
            }
            FileUtils.writeByteArrayToFile(storeFile,image.getBytes());
        }catch(Exception e){
            e.printStackTrace();
            return createJSONObject(-1,"上传失败","");

        }

        return createJSONObject(0,"上传成功",path+name);

    }


}
