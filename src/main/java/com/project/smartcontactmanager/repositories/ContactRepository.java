package com.project.smartcontactmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.project.smartcontactmanager.entities.Contact;

@Component
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	public List<Contact> findByUser(int id);

}
