package com.project.smartcontactmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.smartcontactmanager.entities.Contact;
import com.project.smartcontactmanager.entities.User;
import com.project.smartcontactmanager.repositories.ContactRepository;


@Component
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

//	public List<Contact> getAllContactsOfUser(int uid) {
//		
//		return contactRepository.findByUser(uid);
//	}

	public void addConact(Contact contact,int id) {
		
		User user = new User();
		user.setId(id);
		contact.setUser(user);		
		contactRepository.save(contact);
		
	}

	public List<Contact> getAllContacts() {
		
		return contactRepository.findAll();
	}

}
