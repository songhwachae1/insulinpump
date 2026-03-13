package com.songhwa.insulin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.songhwa.insulin.entity.User;
import com.songhwa.insulin.mapper.UserMapper;
import com.songhwa.insulin.user.CustomUserDetails;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.findByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("No user found with such email: " + username);
		}

		return new CustomUserDetails(username, user.getPassword(), user.getFname(), 
		user.getLname(), AuthorityUtils.createAuthorityList(user.getRole()));
	}

}
