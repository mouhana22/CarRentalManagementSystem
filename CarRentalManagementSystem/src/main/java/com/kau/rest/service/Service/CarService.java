package com.kau.rest.service.Service;

import java.util.List;

import com.kau.rest.service.entity.Car;

public interface CarService {
	List<Car> getAllCars();
	
	Car saveCar(Car car);
	
	Car getCarByPlateNumber(String id);
	
	Car updateCar(Car car);
	
	void deleteCarByPlateNumber(String id);
}
