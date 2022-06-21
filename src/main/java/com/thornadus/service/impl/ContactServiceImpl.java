package com.thornadus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.thornadus.commons.GenericServiceImpl;
import com.thornadus.repo.ContactRepo;
import com.thornadus.model.Contact;
import com.thornadus.service.api.ContactServiceAPI;

@Service
public class ContactServiceImpl extends GenericServiceImpl<Contact, Long> implements ContactServiceAPI {

	@Autowired
	private ContactRepo repo;
	
	@Override
	public CrudRepository<Contact, Long> getRepo() {
		return repo;
	}

}
