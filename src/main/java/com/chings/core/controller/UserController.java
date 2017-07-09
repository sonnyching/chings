package com.chings.core.controller;

import com.chings.core.conpont.AbstractController;
import com.chings.core.model.User;
import com.chings.core.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController extends AbstractController{
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/account")
	public String selectOne(@RequestParam("userid")long id, Model model){
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);
		return "user/account";
	}

	@RequestMapping("/register")
	public String toRegister(){
		return "user/register";
	}

	@RequestMapping("/submitRegister")
	@ResponseBody
	public JSONObject register(User user, String name){
		int result = userService.register(user);
		String info = result>0?"注册成功！" : "注册失败!";
		JSONObject object = new JSONObject();
		object .put("code","info");
		object.put("info",info);
		return object;

	}

	
}
