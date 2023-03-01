package com.project.smartcontactmanager.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/users/{uId}/contacts")
	  public ResponseEntity<Contact> createContact(@PathVariable("uId") int uId,@RequestBody Contact contact) {
	    return contactService.createContact(uId,contact);
	  }
	
	@GetMapping("users/{uId}/contacts")
	public List<Contact> getAllContactsOfUser(@PathVariable("uId") int uid)
	{
		return contactService.getAllContactsOfUser(uid);
	}
	
	@GetMapping("users/{uId}/contacts/{s}")
	public ResponseEntity<List<Contact>> getAllContactsStartingWithName(@PathVariable("uId") int uId ,@PathVariable("s") String s)
	{
		return contactService.getAllContactsStartingWithName(uId,s);
	}
	
	@PutMapping("users/{uId}/contacts/{cId}")
	public ResponseEntity<Contact> updateContact(@PathVariable("uId") int uId,@PathVariable("cId") int cId,@RequestBody Contact UpdateContactDetails)
	{
		return contactService.updateContact(uId,cId,UpdateContactDetails);
	}
	
	@DeleteMapping("users/{uId}/contacts/{cId}")
	public void deleteContact(@PathVariable("uId") int uId,@PathVariable("cId") int cId)
	{
		contactService.deleteContact(uId,cId);
	}

}
