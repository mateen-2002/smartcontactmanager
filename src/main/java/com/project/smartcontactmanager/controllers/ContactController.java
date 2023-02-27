package com.project.smartcontactmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smartcontactmanager.entities.Contact;
import com.project.smartcontactmanager.services.ContactService;

@RestController
@RequestMapping("/smartcontactmanager")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
//	@GetMapping("/contacts/{uid}")
//	public List<Contact> getAllContactsOfUser(@PathVariable("uid") int uid)
//	{
//		return contactService.getAllContactsOfUser(uid);
//	}
	
	@GetMapping("/contacts")
	public List<Contact> getAllContacts()
	{
		return contactService.getAllContacts();
	}
	
	
	@PostMapping("/contacts/{id}")
	public void addContact(@RequestBody Contact contact,@PathVariable("id") int id)
	{
		
		contactService.addConact(contact,id);
	}

}
