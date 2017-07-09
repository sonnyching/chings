package com.chings.core.controller;

import com.chings.core.conpont.AbstractController;
import com.chings.core.model.User;
import com.chings.core.service.IMessageService;
import com.chings.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController extends AbstractController{

    @Autowired
    private IMessageService messageService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/addNotice")
    public String createNotice(){
        User user = userService.getUserById(1);
        int result = messageService.createRemind(100,1,1,"notice", user.id,"喜欢了我的文章");
        return "user/account";
    }

    public void pullUserNotice(){



    }



}
