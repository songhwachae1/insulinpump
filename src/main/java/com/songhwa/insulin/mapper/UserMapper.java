package com.songhwa.insulin.mapper;

import java.sql.SQLException;

import com.songhwa.insulin.entity.User;

public interface UserMapper {
	
	User findByEmail(String email);

	void saveUser(User user) throws SQLException;

}