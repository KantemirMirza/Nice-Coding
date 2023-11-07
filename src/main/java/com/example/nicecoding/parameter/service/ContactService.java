package com.example.nicecoding.parameter.service;

import com.example.nicecoding.parameter.model.Contact;
import com.example.nicecoding.parameter.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
	private final ContactRepository contactRepository;
	
	//Get All Contacts
	public List<Contact> listOfContact() {
		return contactRepository.findAll();
	}

	public Contact findContactById(int id) {
		return contactRepository.findById(id).orElse(null);
	}	
	
	//Delete Contact
	public void deleteContact(Contact contact) {
		contactRepository.delete(contact);
	}
	
	//Save Contact
	public void saveContact( Contact contact) {
		contactRepository.save(contact);
	}

}
