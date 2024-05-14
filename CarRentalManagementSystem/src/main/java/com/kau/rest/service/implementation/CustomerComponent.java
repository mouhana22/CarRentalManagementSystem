package com.kau.rest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kau.rest.service.Service.CustomerService;
import com.kau.rest.service.entity.Customer;
import com.kau.rest.service.repository.JpaCustomer;

@Service
public class CustomerComponent implements CustomerService {
	
	@Autowired
	JpaCustomer MyJpaCustomer;

	public CustomerComponent(JpaCustomer myJpaCustomer) {
		MyJpaCustomer = myJpaCustomer;
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		return MyJpaCustomer.findAll();
	}
	@Override
	public Customer saveCustomer(Customer customer) {
		return MyJpaCustomer.save(customer);
	}
	@Override
	public Customer getCustomerById(Long id) {
		return MyJpaCustomer.findById(id).get();
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		return MyJpaCustomer.save(customer);
	}
	@Override
	public void deleteCustomerById(Long id) {
		MyJpaCustomer.deleteById(id);
	}
	
	
}
