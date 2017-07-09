package com.chings.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chings.core.dao.IUserDao;
import com.chings.core.model.User;
import com.chings.core.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
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
		user.setCreate_time(new Date());
		int result = userDao.register(user);
		return result;
	}
}
