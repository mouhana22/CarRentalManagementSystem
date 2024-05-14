package com.kau.rest.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kau.rest.service.entity.Customer;


public interface JpaCustomer extends JpaRepository<Customer, Long>{

}
