package com.chings.core.dao;

import java.util.List;

import com.chings.core.model.User;

public interface IUserDao {
	
		public User getUserById(String id);
		
		
		public List<User> selectAll();
		
}
