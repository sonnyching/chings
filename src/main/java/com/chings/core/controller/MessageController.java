package com.chings.core.controller;

import com.chings.core.conpont.AbstractController;
import com.chings.core.model.User;
import com.chings.core.service.IMessageService;
import com.chings.core.service.IUserService;
import com.chings.core.utils.Constant;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController extends AbstractController{

    @Autowired
    private IMessageService messageService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/likes")
    @ResponseBody
    public JSONObject likeArticle(HttpServletRequest request,long id){
        JSONObject object = new JSONObject();
        User user = (User)request.getSession().getAttribute(Constant.PRE_LOGIN+request.getSession().getId());
        if(user == null){
            object.put("code",-1);
            object.put("msg","unlogin!");
            return object;
        }
        int result = messageService.createRemind(id,1, Constant.TargetType.ARTICLE, Constant.ActionType.LIKE, user.id,"喜欢了文章");
        object.put("code",0);
        object.put("msg","success");
        return object;
    }

    //用户拉取自身消息
    public void pullUserNotice(){

    }

    //用户注册接受的消息类型
    public void registerMessageType(List<String> types){



    }



}
