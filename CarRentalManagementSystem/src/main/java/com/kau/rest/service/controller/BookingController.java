package com.kau.rest.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import com.kau.rest.service.Service.BookingService;
import com.kau.rest.service.Service.CarService;
import com.kau.rest.service.Service.CustomerService;
import com.kau.rest.service.entity.Booking;
import com.kau.rest.service.entity.Car;
import com.kau.rest.service.entity.Customer;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class BookingController {
	private BookingService bookingService;
	private CarService carService;
	private CustomerService customerService;
	public BookingController(BookingService bookingService, CarService carService, CustomerService customerService ) {
		super();
		this.bookingService = bookingService;
		this.carService = carService;
		this.customerService = customerService;
	}
	

	// handler method to handle list bookings and return mode and view
		@GetMapping("/bookings")
		public String listBookings(Model model) {
			model.addAttribute("bookings", bookingService.getAllBookings());
			return "bookings";
		}
		

		@GetMapping("/bookings/new")
		public String createBookingForm(Model model) {
			List<Car> listcars = carService.getAllCars();
			model.addAttribute("listcars", listcars);
			List<Customer> listcustomers = customerService.getAllCustomers();
			model.addAttribute("listcustomers", listcustomers);
			// create booking object to hold booking form data
			Booking booking = new Booking();
			model.addAttribute("booking", booking);
			return "create_booking";
			
		}
		
		@PostMapping("/bookings")
		public String saveBooking(@ModelAttribute("booking") Booking booking) {
			LocalDate start = LocalDate.parse(booking.getStartDate());
			LocalDate end = LocalDate.parse(booking.getEndDate());
			Period period = Period.between(start, end);
		    int days = period.getDays();
		    booking.setPrice(booking.getCar().getPricePerDay()*days);  
			bookingService.saveBooking(booking);
			return "redirect:/bookings";
		}
		
		@GetMapping("/bookings/edit/{id}")
		public String editBookingForm(@PathVariable Long id, Model model) {
			List<Car> listcars = carService.getAllCars();
			model.addAttribute("listcars", listcars);
			List<Customer> listcustomers = customerService.getAllCustomers();
			model.addAttribute("listcustomers", listcustomers);
			model.addAttribute("booking", bookingService.getBookingById(id));
			return "edit_booking";
		}
		
		@PostMapping("/bookings/{id}")
		public String updateBooking(@PathVariable Long id,@ModelAttribute("booking") Booking booking, Model model) {
			
			// get booking from database by id
			Booking existingBooking = bookingService.getBookingById(id);
			existingBooking.setId(id);
			existingBooking.setCar(booking.getCar());
			existingBooking.setCustomer(booking.getCustomer());
			existingBooking.setStartDate(booking.getStartDate());
			existingBooking.setEndDate(booking.getEndDate());
			
			LocalDate start = LocalDate.parse(booking.getStartDate());
			LocalDate end = LocalDate.parse(booking.getEndDate());
			Period period = Period.between(start, end);
		    int days = period.getDays();
			existingBooking.setPrice(booking.getCar().getPricePerDay()*days);
			
			// save updated booking object
			bookingService.updateBooking(existingBooking);
			return "redirect:/bookings";		
		}
		
		// handler method to handle delete booking request
		
		@GetMapping("/bookings/{id}")
		public String deleteBooking(@PathVariable  Long id) {
			bookingService.deleteBookingById(id);
			return "redirect:/bookings";
		}
	
}
