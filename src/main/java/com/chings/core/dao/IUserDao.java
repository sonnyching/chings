package com.chings.core.dao;

import com.chings.core.model.User;

public interface IUserDao {
	
	public User findById(long id);
		
//		public List<User> selectAll();

	public int register(User user);
		
}
