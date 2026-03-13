package com.songhwa.insulin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.songhwa.insulin.service.CustomUserDetailService;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomUserDetailService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
			
		return authProvider;
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authenticationProvider(authenticationProvider());

		http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(requests -> 
			requests.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
			.requestMatchers("/main", 
			"/register", 
			"/login", 
			"/error",
			"/auth/login",
			"/auth/register",
			"/error",
			"/css/**",
      "/js/**",
			"/auth/js/**",
			"/auth/css/**"
		).permitAll()
			.anyRequest().authenticated()
			)
			.formLogin(login ->
					login.loginPage("/login")
					.loginProcessingUrl("/auth/login")
					.usernameParameter("email")
					.defaultSuccessUrl("/main")
					.failureUrl("/error")
					.permitAll()
			)
			.logout(logout -> logout.logoutSuccessUrl("/login").permitAll());

		return http.build();
	}

}