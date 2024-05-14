package com.kau.rest.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kau.rest.service.entity.Booking;


public interface JpaBooking extends JpaRepository<Booking, Long>{

}
