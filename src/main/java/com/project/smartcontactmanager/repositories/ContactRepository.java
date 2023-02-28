package com.project.smartcontactmanager.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.project.smartcontactmanager.entities.Contact;

import jakarta.transaction.Transactional;

@Component
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	public Contact findById(int cId);
	public List<Contact> findByUserId(int uId);
	public List<Contact> findByUserIdAndFirstNameStartingWith(int uId,String s);

}
