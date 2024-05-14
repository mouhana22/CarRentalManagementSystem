package com.kau.rest.service.Service;

import java.util.List;

import com.kau.rest.service.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	
	Customer saveCustomer(Customer customer);
	
	Customer getCustomerById(Long id);
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomerById(Long id);
}
