package com.chings.core.controller;

import com.chings.core.conpont.AbstractController;
import com.chings.core.exception.UserNotFoundException;
import com.chings.core.model.User;
import com.chings.core.service.IUserService;
import com.chings.core.utils.Constance;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


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

	@RequestMapping("/register/submitRegister")
	@ResponseBody
	public JSONObject register(User user, String name){
		int result = userService.register(user);
		String info = result>0?"注册成功！" : "注册失败!";
		JSONObject object = new JSONObject();
		object .put("code","info");
		object.put("info",info);
		return object;

	}

	@RequestMapping("/login/submitLogin")
	@ResponseBody
	public JSONObject login(HttpServletRequest res, String password, String name){
		JSONObject object = new JSONObject();

		try {
			User user = userService.login(password,name);
			if(user!=null){
				res.getSession().setAttribute(Constance.PRE_LOGIN+res.getSession().getId(),user);
			}
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			object.put("code",e.code);
			object.put("msg",e.msg);
			return object;
		}

		object .put("code",0);
		object.put("msg","登陆成功！");
		return object;
	}

	@RequestMapping("/login")
	public String toLogin(){
		return "user/loginPage";
	}

	
}
