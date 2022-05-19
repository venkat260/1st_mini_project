package com.venkatesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatesh.entity.Contact;
import com.venkatesh.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	public ContactRepository repo;

	@Override
	public String upsert(Contact obj) {
		Contact save = repo.save(obj);
		return "sucessful";
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> list = repo.findAll();
		return list;
	}

	@Override
	public Contact getContact(Integer cid) {
		Optional<Contact> findById = repo.findById(cid);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public String delectContact(Integer cid) {
		//repo.deleteById(cid);  this is hard delete 
		
		//this is soft delete
		Optional<Contact> findById = repo.findById(cid);
		if(findById.isPresent())
		{
			Contact contact = findById.get();
			
			contact.setActiveSw("N");
			
			repo.save(contact);
			
		}
		
		return "deleted Sucessful" ;
	}

}
