package com.chings.core.controller;

import com.chings.core.conpont.AbstractController;
import com.chings.core.exception.HandleFailedException;
import com.chings.core.exception.HandleSuccessException;
import com.chings.core.exception.UserNotFoundException;
import com.chings.core.model.User;
import com.chings.core.service.IUserService;
import com.chings.core.utils.Log;
import com.chings.core.utils.ResponseUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserController extends AbstractController{
	@Autowired
	private IUserService userService;
	
/*	@RequestMapping("/account")
	public String accountHome(HttpServletRequest request, HttpServletResponse response,Model model){
		User user = (User)request.getSession().getAttribute(Constant.PRE_LOGIN+request.getSession().getId());
		if(user == null){
			try {
				response.sendRedirect("/user/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("user", user);
		return "user/account";
	}*/
/*
	@RequestMapping("/register")
	public String toRegister(){
		return "user/register";
	}*/

	@RequestMapping("/register/submitRegister")
	@ResponseBody
	public JSONObject register(User user, String name){
		int result = userService.register(user);
		String info = result>0?"注册成功！" : "注册失败!";
		JSONObject object = result>0?ResponseUtils.responseJosn(new HandleSuccessException(info))
				:ResponseUtils.responseJosn(new HandleFailedException(info));
		return object;

	}

	@RequestMapping("/login/submitLogin")
	@ResponseBody
	public JSONObject login(HttpServletRequest res, String password, String name){
		JSONObject object = new JSONObject();

		User user = null;
		try {
//			Log.info("name="+name+",pwd="+password);
			user = userService.login(password,name);
			if(user!=null){
				res.getSession().setAttribute(res.getSession().getId(),user);
			}
		} catch (UserNotFoundException e) {
			//e.printStackTrace();
			object = ResponseUtils.responseJosn(e);
			return object;
		} catch (RuntimeException e2) {
			//object = ResponseUtils.responseJosn(e2);
			return object;
		}

		if(user==null){
			return object;
		}

		object = ResponseUtils.responseJosn(new HandleSuccessException("登录成功！"));
		object.put("token",res.getSession().getId());
		return object;
	}

/*
	@RequestMapping("/login")
	public String toLogin(){
		return "user/loginPage";
	}*/

	@RequestMapping("/test")
	@ResponseBody
	public JSONObject test(){
		JSONObject object = new JSONObject();
		object .put("code",0);
		object.put("msg","test");
		return object;
	}

	/**
	 * 判断用户是否登陆成功
	 * @param token
	 * @param request
	 * @return
	 */
	@RequestMapping("/isLogin")
	@ResponseBody
	public JSONObject isUserLogin(String token,HttpServletRequest request){
		//实际上拦截器已经校验了session,若能进这里来的话，说明已经登陆成功了
		return createJSONObject(0,"成功","");

	}


}
