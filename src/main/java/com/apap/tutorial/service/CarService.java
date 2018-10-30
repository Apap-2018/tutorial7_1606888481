package com.apap.tutorial.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial.model.CarModel;

public interface CarService {
	void addCar(CarModel car);
	void deleteCar(CarModel car);
    Optional<CarModel> getCarDetailById(Long id);
    void updateCar(Long id, CarModel carBaru);
	List<CarModel> getCarList();

}
