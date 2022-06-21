package com.thornadus.repo;

import org.springframework.data.repository.CrudRepository;

import com.thornadus.model.Contact;

public interface ContactRepo extends CrudRepository<Contact, Long> {

}
