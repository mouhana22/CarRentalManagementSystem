package com.kau.rest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kau.rest.service.Service.BookingService;
import com.kau.rest.service.entity.Booking;
import com.kau.rest.service.repository.JpaBooking;

@Service
public class BookingComponent implements BookingService{
	@Autowired
	JpaBooking MyJpaBooking;

	public BookingComponent(JpaBooking myJpaBooking) {
		MyJpaBooking = myJpaBooking;
	}
	@Override
	public List<Booking> getAllBookings(){
		return MyJpaBooking.findAll();
	}
	@Override
	public Booking saveBooking(Booking booking) {
		return MyJpaBooking.save(booking);
	}
	@Override
	public Booking getBookingById(Long id) {
		return MyJpaBooking.findById(id).get();
	}
	@Override
	public Booking updateBooking(Booking booking) {
		return MyJpaBooking.save(booking);
	}
	@Override
	public void deleteBookingById(Long id) {
		MyJpaBooking.deleteById(id);
	}
}
