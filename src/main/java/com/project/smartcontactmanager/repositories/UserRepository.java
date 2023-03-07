package com.project.smartcontactmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.project.smartcontactmanager.entities.User;

@Component
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findById(int id);

	public User findByEmail(String username);

}
