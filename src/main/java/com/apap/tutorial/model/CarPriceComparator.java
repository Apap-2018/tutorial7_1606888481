package com.apap.tutorial.model;
import java.util.Comparator;

import com.apap.tutorial.model.CarModel;

public class CarPriceComparator implements Comparator<CarModel> {
	@Override
	public int compare(CarModel mobilSatu, CarModel mobilDua) {
		return(mobilSatu.getPrice() - mobilDua.getPrice());
	}
	

}
