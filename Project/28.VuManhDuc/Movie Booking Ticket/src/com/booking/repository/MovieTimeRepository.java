package com.booking.repository;

import java.util.List;

import com.booking.entity.MovieTimeEntity;

public interface MovieTimeRepository {
	List<MovieTimeEntity> findAll();
}
