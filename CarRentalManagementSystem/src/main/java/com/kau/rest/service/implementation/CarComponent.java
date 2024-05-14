package com.kau.rest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kau.rest.service.Service.CarService;
import com.kau.rest.service.entity.Car;
import com.kau.rest.service.repository.JpaCar;


@Service
public class CarComponent implements CarService{
	@Autowired
	JpaCar MyJpaCar;
	
	
	CarComponent(JpaCar myJpaCar) {
		MyJpaCar = myJpaCar;
	}
	
	@Override
	public List<Car> getAllCars(){
		return MyJpaCar.findAll();
	}
	@Override
	public Car saveCar(Car car) {
		return MyJpaCar.save(car);
	}
	@Override
	public Car getCarByPlateNumber(String id) {
		return MyJpaCar.findById(id).get();
	}
	@Override
	public Car updateCar(Car car) {
		return MyJpaCar.save(car);
	}
	@Override
	public void deleteCarByPlateNumber(String id) {
		MyJpaCar.deleteById(id);	
	}
}
