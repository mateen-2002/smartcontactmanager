package com.project.smartcontactmanager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.smartcontactmanager.services.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	public static final String [] public_urls = {
			"/token"
			};
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(BCryptVersion.$2A);
	}
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
	}
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(public_urls).permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	

}
