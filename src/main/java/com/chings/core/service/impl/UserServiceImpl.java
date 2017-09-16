package com.chings.core.service.impl;

import com.chings.core.dao.IUserDao;
import com.chings.core.exception.HandleFailedException;
import com.chings.core.exception.UserExistException;
import com.chings.core.exception.UserNotFoundException;
import com.chings.core.model.User;
import com.chings.core.service.IEventService;
import com.chings.core.service.IUserService;
import com.chings.core.utils.Constant;
import com.chings.core.utils.Log;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IEventService eventService;
	
	@Override
	public User getUserById(long id) {

		return userDao.findById(id);
	}

	@Override
	@Transactional
	public int register(User user) {
		if(user==null){
			new RuntimeException("填寫的信息不完整");
			return -1;
		}

		User existUser = userDao.findUserByName(user.name);

		if(existUser!=null){
			throw  new UserExistException("用户名已存在");
		}

		User existUser2 = userDao.findUserByEmail(user.email);

		if(existUser2!=null){
			throw  new UserExistException("注册邮箱已存在");
		}

		user.setCreate_time(new Date());
		String pwAfterMd5 = DigestUtils.md5Hex(user.password);
		user.setPassword(pwAfterMd5);
		int userID = userDao.register(user);

		eventService.addEvent(userID, Constant.UserEventType.submit.ordinal(),"注册成功");

		return userID;
	}

	@Override
	public User login(String password, String name) {

		User user = userDao.findByAccountName(name);
		if(user==null){
			throw new UserNotFoundException("用户名未注册");
		}
		String pwAfterMd5 = DigestUtils.md5Hex(password);
		if(!user.password.equals(pwAfterMd5)){
			throw new HandleFailedException("用户名与密码不匹配");
		}

		eventService.addEvent(user.id, Constant.UserEventType.login.ordinal(),"登陆成功");
		Log.info(user.name+"登陆成功！");

		return user;
	}



}
