package com.apap.tutorial.controller;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial.model.*;
import com.apap.tutorial.rest.*;
import com.apap.tutorial.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;

	@PutMapping(value = "/{carId}")
	private String updateCar(
			@PathVariable (value = "carId") long id,
			@RequestParam("brand") Optional<String> brand,
			@RequestParam("type") Optional<String> type,
			@RequestParam("price") Optional<Integer> price,
			@RequestParam("amount") Optional<Integer> amount,
			@RequestParam("dealerId") Optional<Long> dealerId) {
		CarModel car = carService.getCarDetailById(id).get();
		if (car.equals(null)) {
			return "Couldn't find your dealer";
		}
		if(brand.isPresent()) {
			car.setBrand(brand.get());			
		}
		if(type.isPresent()) {
			car.setType(type.get());			
		}
		if(price.isPresent()) {
			car.setPrice(price.get());			
		}
		if(amount.isPresent()) {
			car.setAmount(amount.get());			
		}
		DealerModel dealerTemp = dealerService.getDealerDetailById(id).get();
		car.setDealer(dealerTemp);
		
		carService.updateCar(id, car);
		return "car update success";
	}
	
	@PostMapping()
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		carService.addCar(car); 
		return car;
	}
	
	@GetMapping(value = "/{carId}")
	private CarModel viewCar(@PathVariable ("carId") long carId, Model model) {
		return carService.getCarDetailById(carId).get();
	}
	
	@GetMapping()
	private List<CarModel> viewAllCar(Model model) {
		return carService.getCarList();
	}
	
	@DeleteMapping(value = "/{carId}")
	private String deleteCar(@PathVariable("carId") long id, Model model) {
		CarModel car = carService.getCarDetailById(id).get();
		carService.deleteCar(car);
		return "car has been deleted";
	}
	
}