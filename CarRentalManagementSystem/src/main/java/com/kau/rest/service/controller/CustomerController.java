package com.kau.rest.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kau.rest.service.Service.CustomerService;
import com.kau.rest.service.entity.Customer;

@Controller
public class CustomerController {
	private CustomerService customerService;
	
	
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}


	// handler method to handle list customers and return mode and view
		@GetMapping("/customers")
		public String listCustomers(Model model) {
			model.addAttribute("customers", customerService.getAllCustomers());
			return "customers";
		}
		

		@GetMapping("/customers/new")
		public String createCustomerForm(Model model) {
			
			// create customer object to hold customers form data
			Customer customer = new Customer();
			model.addAttribute("customer", customer);
			return "create_customer";
			
		}
		
		@PostMapping("/customers")
		public String saveCustomer(@ModelAttribute("customer") Customer customer) {
			customerService.saveCustomer(customer);
			return "redirect:/customers";
		}
		
		@GetMapping("/customers/edit/{id}")
		public String editCustomerForm(@PathVariable Long id, Model model) {
			model.addAttribute("customer", customerService.getCustomerById(id));
			return "edit_customer";
		}
		
		@PostMapping("/customers/{id}")
		public String updateCustomer(@PathVariable Long id,@ModelAttribute("customer") Customer customer, Model model) {
			
			// get student from database by id
			Customer existingCustomer = customerService.getCustomerById(id);
			existingCustomer.setId(id);
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setSecondName(customer.getSecondName());
			existingCustomer.setPhoneNumber(customer.getPhoneNumber());
			
			// save updated student object
			customerService.updateCustomer(existingCustomer);
			return "redirect:/customers";		
		}
		
		// handler method to handle delete student request
		
		@GetMapping("/customers/{id}")
		public String deleteCustomer(@PathVariable  Long id) {
			customerService.deleteCustomerById(id);
			return "redirect:/customers";
		}
		
}
