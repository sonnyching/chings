package com.chings.core.service;

import com.chings.core.exception.UserNotFoundException;
import com.chings.core.model.User;

public interface IUserService {
	public User getUserById(long userId);
	public int register(User user);
	public User login(String password,String accountName) throws UserNotFoundException;

}
