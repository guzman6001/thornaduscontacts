package com.thornadus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thornadus.model.Contact;
import com.thornadus.model.History;
import com.thornadus.service.api.ContactServiceAPI;

@RestController
@RequestMapping(value = "/api/")
@CrossOrigin("*")
public class ContactRestController {

	@Autowired
	private ContactServiceAPI contactServiceAPI;

	@GetMapping(value = "/contacts")
	public List<Contact> getAll() {
		return contactServiceAPI.getAll();
	}
	
	@GetMapping(value = "/contacts/{id}")
	public Contact find(@PathVariable Long id) {
		return contactServiceAPI.get(id);
	}

	@PostMapping(value = "/contacts")
	public ResponseEntity<Contact> save(@RequestBody @Valid Contact contact) {
		
		
		if (contact.getHistory()==null) {
			contact.setHistory(new ArrayList<>());
		}
		if (contact.getId() == null) {
			contact.setHistory(new ArrayList<>());
		}else {
			Contact oldContact = contactServiceAPI.get(contact.getId());
			History histery = new History();
			histery.setEmail(oldContact.getEmail());
			histery.setFirstName(oldContact.getFirstName());
			histery.setLastName(oldContact.getLastName());
			histery.setPhone(oldContact.getPhone());
			List<History> oldHistory = oldContact.getHistory();
			oldHistory.add(histery);
			contact.setHistory(oldHistory);
		}
		
		Contact obj = contactServiceAPI.save(contact);
		return new ResponseEntity<Contact>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value = "/contacts/{id}")
	public ResponseEntity<Contact> delete(@PathVariable Long id) {
		Contact contact = contactServiceAPI.get(id);
		if (contact != null) {
			contactServiceAPI.delete(id);
		} else {
			return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

}
