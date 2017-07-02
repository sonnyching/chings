package com.chings.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chings.core.model.User;
import com.chings.core.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/show")
	public String selectOne(HttpServletRequest request,Model model){
		String userId = request.getParameter("id");
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping("/all")
	public String selectAll(HttpServletRequest request,Model model){
		List<User> list = userService.selectAll();
		model.addAttribute("user", list.get(0));
		return "showUser";
	}
	
}
