package com.songhwa.insulin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String fname;
	
	private String lname;
	
	private String email;

	private String password;

	private String role;

	@Override
	public String toString() {
		return "User [email = " + email
		+ ", first name = " + fname
		+ ", last name = " + lname
		+ ", role = " + role
		+ "]";
	}
}