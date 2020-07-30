package com.booking.entity;

import java.util.Date;

public class MovieEntity {
	private int idMovie;
	private Date movieDay;
	private int idTheater;
	private String movieName;
	private int idMovTime;
	public MovieEntity() {}
	public MovieEntity(int idMovie, Date movieDay, int idTheater, String movieName, int idMovTime) {
		super();
		this.idMovie = idMovie;
		this.movieDay = movieDay;
		this.idTheater = idTheater;
		this.movieName = movieName;
		this.idMovTime = idMovTime;
	}
	public int getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	public Date getMovieDay() {
		return movieDay;
	}
	public void setMovieDay(Date movieDay) {
		this.movieDay = movieDay;
	}
	public int getIdTheater() {
		return idTheater;
	}
	public void setIdTheater(int idTheater) {
		this.idTheater = idTheater;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getIdMovTime() {
		return idMovTime;
	}
	public void setIdMovTime(int idMovTime) {
		this.idMovTime = idMovTime;
	}
	
	
}
