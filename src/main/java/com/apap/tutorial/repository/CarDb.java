package com.apap.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial.model.CarModel;

public interface CarDb extends JpaRepository<CarModel, Long> {
	CarModel findByType(String type);
}
