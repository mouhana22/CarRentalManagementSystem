package com.kau.rest.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
    private Long id;
    private String firstName;
    private String secondName;
    private int phoneNumber;
    
	public Customer() {
		super();
	}

	public Customer(Long id, String firstName, String secondName, int phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
}
