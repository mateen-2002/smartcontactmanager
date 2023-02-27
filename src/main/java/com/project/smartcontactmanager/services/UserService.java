package com.project.smartcontactmanager.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.project.smartcontactmanager.entities.User;
import com.project.smartcontactmanager.repositories.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<List<User>> getAllUsers() 
	{
		
		List<User> users = new ArrayList<User>();

	    userRepository.findAll().forEach(users::add);

	    if (users.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(users, HttpStatus.OK);
	}

	public ResponseEntity<User> getUserById(int id) 
	{
	    User user = userRepository.findById(id);
	    if(user == null)
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    
	    return new ResponseEntity<>(user, HttpStatus.OK);
	}

	public void addUser(User user) {
		
		
		userRepository.save(user);
		
	}

}
