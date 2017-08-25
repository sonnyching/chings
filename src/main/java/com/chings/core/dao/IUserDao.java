package com.chings.core.dao;

import com.chings.core.model.User;

public interface IUserDao {
	
	public User findById(long id);

	public User findUserByName(String name);

	public User findUserByEmail(String email);

	public User findByAccountName(String name);

//		public List<User> selectAll();

	public int register(User user);

}
