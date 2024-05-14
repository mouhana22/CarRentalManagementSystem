package com.kau.rest.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Booking {
	@Id
    private Long id;
	
	@ManyToOne
	private Car car;
	
	@ManyToOne
	private Customer customer;
	
	private String startDate;
	private String endDate;
	private double price;
	
	public Booking() {
		super();
	}

	public Booking(Long id, Car car, Customer customer, String startDate, String endDate, double price) {
		super();
		this.id = id;
		this.car = car;
		this.customer = customer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
