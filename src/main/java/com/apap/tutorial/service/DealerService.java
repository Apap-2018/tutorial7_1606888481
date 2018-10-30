package com.apap.tutorial.service;

import java.util.Optional;

import com.apap.tutorial.model.CarModel;
import com.apap.tutorial.model.DealerModel;

import java.util.List;

public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	List<DealerModel> getDealerList();
	void addDealer(DealerModel dealer);
	void deleteDealer(DealerModel dealer);
	void updateDealer(Long id, DealerModel dealer);
	List<CarModel> getListCarOrderByPriceAsc(Long dealerId);
	
}
