package com.chings.core.service;

import com.chings.core.model.User;

public interface IUserService {

	public User getUserById(long userId);
	public int register(User user);

}
