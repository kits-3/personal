package com.booking.repository;

import java.util.List;

import com.booking.entity.TheaterEntity;

public interface TheaterRepository {
	void addTheater();
	void updateTheater(int idTheater);
	void deleteTheater(int idTheater);
	List<TheaterEntity> findAll();
	List<TheaterEntity> findTheaterByDay(String day);
}
