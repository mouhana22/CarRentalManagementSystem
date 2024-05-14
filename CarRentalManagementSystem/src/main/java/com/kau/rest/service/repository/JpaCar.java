package com.kau.rest.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kau.rest.service.entity.Car;


public interface JpaCar extends JpaRepository<Car, String>{

}
