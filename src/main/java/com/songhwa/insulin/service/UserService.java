package com.songhwa.insulin.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.songhwa.insulin.mapper.UserMapper;
import com.songhwa.insulin.entity.User;
import com.songhwa.insulin.exception.UserAlreadyExistsException;

@Service
public class UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserMapper userMapper;

	public User findByEmail(String email) {
		return userMapper.findByEmail(email);
	}

	public void saveUser(User user) throws SQLException {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userMapper.saveUser(user);
	}

	public User registerUser(User user) throws UserAlreadyExistsException, SQLException {
		if (findByEmail(user.getEmail()) != null) {
			throw new UserAlreadyExistsException("User with the email account already exists : " + user.getEmail());
		}

		saveUser(user);
		
		return user;
	}
}
