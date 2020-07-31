package com.booking.repository;

import java.util.List;

import com.booking.entity.PriceEntity;

public interface PriceRepository {
	void add();
	List<PriceEntity> findAll();
}
