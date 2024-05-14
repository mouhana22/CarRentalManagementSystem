package com.kau.rest.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kau.rest.service.Service.CarService;
import com.kau.rest.service.entity.Car;



@Controller
public class CarController {
	
	private CarService carService;

	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/")
	public String welcomeMessage() {
		return "home";
	}
	// handler method to handle list students and return mode and view
		@GetMapping("/cars")
		public String listCars(Model model) {
			model.addAttribute("cars", carService.getAllCars());
			return "cars";
		}
		

		@GetMapping("/cars/new")
		public String createCarForm(Model model) {
			
			// create student object to hold student form data
			Car car = new Car();
			model.addAttribute("car", car);
			return "create_car";
			
		}
		
		@PostMapping("/cars")
		public String saveCar(@ModelAttribute("car") Car car) {
			carService.saveCar(car);
			return "redirect:/cars";
		}
		
		@GetMapping("/cars/edit/{platNumber}")
		public String editCarForm(@PathVariable String platNumber, Model model) {
			model.addAttribute("car", carService.getCarByPlateNumber(platNumber));
			return "edit_car";
		}
		
		@PostMapping("/cars/{platNumber}")
		public String updateCar(@PathVariable String platNumber,@ModelAttribute("car") Car car, Model model) {
			
			// get student from database by id
			Car existingCar = carService.getCarByPlateNumber(platNumber);
			existingCar.setPlateNumber(platNumber);
			existingCar.setModel(car.getModel());
			existingCar.setManufacturedYear(car.getManufacturedYear());
			existingCar.setCapacity(car.getCapacity());
			existingCar.setPricePerDay(car.getPricePerDay());
			
			// save updated student object
			carService.updateCar(existingCar);
			return "redirect:/cars";		
		}
		
		// handler method to handle delete student request
		
		@GetMapping("/cars/{platNumber}")
		public String deleteCar(@PathVariable  String platNumber) {
			carService.deleteCarByPlateNumber(platNumber);
			return "redirect:/cars";
		}
		

}
