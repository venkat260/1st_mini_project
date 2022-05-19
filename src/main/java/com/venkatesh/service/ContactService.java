package com.venkatesh.service;

import java.util.List;

import com.venkatesh.entity.Contact;

public interface ContactService {
	
	String upsert(Contact obj);
	
	List<Contact> getAllContacts();
	
	Contact getContact(Integer cid);
	
	String delectContact(Integer cid);
	
}