package com.project.smartcontactmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.project.smartcontactmanager.entities.CustomUserDetails;
import com.project.smartcontactmanager.entities.User;
import com.project.smartcontactmanager.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if(user == null)
			throw new UsernameNotFoundException("No User Found");
		return new CustomUserDetails(user);
	}

}
