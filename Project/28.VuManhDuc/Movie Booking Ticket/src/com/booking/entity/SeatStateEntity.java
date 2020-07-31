package com.booking.entity;

public class SeatStateEntity {
	private int idSeatState;
	private int idMovTime;
	private int idTheater;
	private int empty;
	private int idMovie;
	public SeatStateEntity() {}
	public SeatStateEntity(int idSeatState, int idMovTime, int idTheater, int empty, int idMovie) {
		super();
		this.idSeatState = idSeatState;
		this.idMovTime = idMovTime;
		this.idTheater = idTheater;
		this.empty = empty;
		this.idMovie = idMovie;
	}
	public int getIdSeatState() {
		return idSeatState;
	}
	public void setIdSeatState(int idSeatState) {
		this.idSeatState = idSeatState;
	}
	public int getIdMovTime() {
		return idMovTime;
	}
	public void setIdMovTime(int idMovTime) {
		this.idMovTime = idMovTime;
	}
	public int getIdTheater() {
		return idTheater;
	}
	public void setIdTheater(int idTheater) {
		this.idTheater = idTheater;
	}
	public int getEmpty() {
		return empty;
	}
	public void setEmpty(int empty) {
		this.empty = empty;
	}
	public int getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	
	
}
