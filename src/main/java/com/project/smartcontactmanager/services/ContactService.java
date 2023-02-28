package com.project.smartcontactmanager.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.project.smartcontactmanager.entities.Contact;
import com.project.smartcontactmanager.entities.User;
import com.project.smartcontactmanager.exception.ResourceNotFoundException;
import com.project.smartcontactmanager.repositories.ContactRepository;
import com.project.smartcontactmanager.repositories.UserRepository;


@Component
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Contact> getAllContactsOfUser(int uid) {
		
		if (!userRepository.existsById(uid)) {
		      throw new ResourceNotFoundException("Not found user with id = " + uid);
		    }

		    List<Contact> contacts = contactRepository.findByUserId(uid);
		    return contacts;
	}

	public ResponseEntity<Contact> createContact(int uId, Contact newContact) {
		
			User user = userRepository.findById(uId);
			if(user == null)
				throw new ResourceNotFoundException("Not found user with id = " + uId);
			newContact.setUser(user);
		    contactRepository.save(newContact);
		    return new ResponseEntity<>(newContact, HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<Contact>> getAllContactsStartingWithName(int uId,String s) {
		
		User user = userRepository.findById(uId);
		if(user == null)
			throw new ResourceNotFoundException("Not found user with id = " + uId);
		List<Contact> res = (List<Contact>)contactRepository.findByUserIdAndFirstNameStartingWith(uId, s);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	public ResponseEntity<Contact> updateContact(int uId, int cId, Contact updateContactDetails) {
		User user = userRepository.findById(uId);
		if(user == null)
			throw new ResourceNotFoundException("Not found user with id = " + uId);
		else
		{
			Contact contact = contactRepository.findById(cId);
			if(contact==null)
				throw new ResourceNotFoundException("Not found contact with id = " + cId);
			else
			{
				contact.setFirstName(updateContactDetails.getFirstName());
				contact.setLastName(updateContactDetails.getLastName());
				contact.setEmail(updateContactDetails.getEmail());
				contact.setPhone(updateContactDetails.getPhone());
				contact.setWork(updateContactDetails.getWork());
				return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.OK);
			}
		}
	}

	public void deleteContact(int uId, int cId) {
		
		User user = userRepository.findById(uId);
		if(user == null)
			throw new ResourceNotFoundException("Not found user with id = " + uId);
		else
		{
			Contact contact = contactRepository.findById(cId);
			if(contact==null)
				throw new ResourceNotFoundException("Not found contact with id = " + cId);
			else
			{
				contactRepository.deleteById(cId);
			}
		}
	}
}
