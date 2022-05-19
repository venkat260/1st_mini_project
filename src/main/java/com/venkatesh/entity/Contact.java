package com.venkatesh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="CONTACT_DTLS")
@Data
public class Contact {
	
	@Id
	@GeneratedValue
	int cid   ;
	
	String nameFirst;
	String email;
	long phno;
	String activeSw;
	
	

}
