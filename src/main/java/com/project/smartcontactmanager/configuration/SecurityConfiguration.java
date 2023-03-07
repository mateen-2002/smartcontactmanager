package com.project.smartcontactmanager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

import com.project.smartcontactmanager.services.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(BCryptVersion.$2A);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http
			.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	

}
