package com.chings.core.service;

import java.util.List;

import com.chings.core.model.User;

public interface IUserService {
	public User getUserById(String userId);
	public List<User> selectAll();
}
