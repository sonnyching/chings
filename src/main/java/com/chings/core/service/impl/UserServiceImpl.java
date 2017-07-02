package com.chings.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chings.core.dao.IUserDao;
import com.chings.core.model.User;
import com.chings.core.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserById(String userId) {
		if(userId==null || "".equals(userId)){
			return null;
		}
		return userDao.getUserById(userId);
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

}
