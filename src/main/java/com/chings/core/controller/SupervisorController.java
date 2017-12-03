package com.chings.core.controller;

import com.chings.core.config.Constant;
import com.chings.core.conpont.AbstractController;
import com.chings.core.service.ISupervisorService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sonnyching on 2017/12/3.
 */
@Controller
@RequestMapping("supervisor")
public class SupervisorController extends AbstractController {

    @Autowired
    ISupervisorService service;

    @RequestMapping("/dbBackup")
    @ResponseBody
    public JSONObject dbBackup(HttpServletRequest req){
//        String projectRoot = req.getSession().getServletContext().getRealPath("/");
//        boolean result = service.makeBdBackup(projectRoot + Constant.dbBackupPath);
//        return createJSONObject(result?1:-1,result?"备份成功":"备份失败",null);
        return null;

    }

    @RequestMapping("/staticsBackup")
    @ResponseBody
    public JSONObject staticsBackup(HttpServletRequest req){

        String projectRoot = req.getSession().getServletContext().getRealPath("/");

        boolean result = service.staticsBackup(projectRoot + Constant.uploadPath,
                Constant.uploadBackupPath);

        return createJSONObject(result?1:-1,result?"备份成功":"备份失败",null);
    }

}
