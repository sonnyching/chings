package com.chings.core.service.impl;

import com.chings.core.dao.IUserDao;
import com.chings.core.exception.SystemException;
import com.chings.core.exception.UserNotFoundException;
import com.chings.core.model.User;
import com.chings.core.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.util.Date;

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
		String pwAfterMd5 = DigestUtils.md5Hex(user.password);
		user.setPassword(pwAfterMd5);
		int result = userDao.register(user);
		return result;
	}

	@Override
	public User login(String password, String name) {
		User user = userDao.findByAccountName(name);
		if(user==null){
			throw new UserNotFoundException(-1,"用户名未注册");
		}
		String pwAfterMd5 = DigestUtils.md5Hex(password);
		if(!user.password.equals(pwAfterMd5)){
			return null;
		}
		return user;
	}

}
