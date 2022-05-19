package com.venkatesh.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkatesh.entity.Contact;
import com.venkatesh.service.ContactService;

@RestController
public class ContactRestController {
	
	@Autowired
	public ContactService service;
	
	@PostMapping("/contact")//done
	public ResponseEntity<String> contact(@RequestBody Contact obj)
	{
		String status = service.upsert(obj);
		
		return new ResponseEntity<String>(status, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/contacts") //done
	public ResponseEntity<List<Contact>> getContact()
	{
		List<Contact> list = service.getAllContacts();
		
		return new ResponseEntity<List<Contact>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/contact/{cid}") //done
	public ResponseEntity<Contact> getContact(@PathVariable Integer cid)
	{
		Contact contact = service.getContact(cid);
		
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

	@DeleteMapping("/contact/{cid}") //completed
	public ResponseEntity<String> deleteContact(@PathVariable Integer cid)
	{
		String delectContact = service.delectContact(cid);
		
		return new ResponseEntity<>(delectContact, HttpStatus.OK);
	}
}
