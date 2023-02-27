package com.project.smartcontactmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smartcontactmanager.entities.User;
import com.project.smartcontactmanager.services.UserService;

@RestController
@RequestMapping("/smartcontactmanager")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		System.out.println("Hi u r in user controller");
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByid(@PathVariable("id") int id)
	{
		return userService.getUserById(id);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user)
	{
		userService.addUser(user);
	}
	

}
