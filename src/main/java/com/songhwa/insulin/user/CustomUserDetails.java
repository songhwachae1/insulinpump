package com.songhwa.insulin.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private String username;
	
	private String password;
	
	private String fullName;

	private String fname;

	private String lname;

	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(String username, String password, String fname, String lname, Collection<? extends GrantedAuthority>authorities) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.fullName = fname + " " + lname;
		this.authorities = authorities;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getFullName() {
		return fullName;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
