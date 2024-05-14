package com.kau.rest.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
	 	@Id
	    private String plateNumber;
	    private String model;
	    private int manufacturedYear;
	    private int capacity;
	    private double pricePerDay;
	    
		
		
		public Car(String plateNumber, String model, int manufacturedYear, int capacity, double pricePerDay) {
			super();
			this.plateNumber = plateNumber;
			this.model = model;
			this.manufacturedYear = manufacturedYear;
			this.capacity = capacity;
			this.pricePerDay = pricePerDay;
		}

		public Car() {
			super();
		}
		
		public double getPricePerDay() {
			return pricePerDay;
		}

		public void setPricePerDay(double pricePerDay) {
			this.pricePerDay = pricePerDay;
		}

		public int getManufacturedYear() {
			return manufacturedYear;
		}

		public void setManufacturedYear(int manufacturedYear) {
			this.manufacturedYear = manufacturedYear;
		}

		public String getPlateNumber() {
			return plateNumber;
		}
		public void setPlateNumber(String plateNumber) {
			this.plateNumber = plateNumber;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
	    
		
	    
}
