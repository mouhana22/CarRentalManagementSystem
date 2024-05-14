package com.kau.rest.service.Service;

import java.util.List;

import com.kau.rest.service.entity.Booking;

public interface BookingService {
	List<Booking> getAllBookings();
	
	Booking saveBooking(Booking booking);
	
	Booking getBookingById(Long id);
	
	Booking updateBooking(Booking booking);
	
	void deleteBookingById(Long id);
}
