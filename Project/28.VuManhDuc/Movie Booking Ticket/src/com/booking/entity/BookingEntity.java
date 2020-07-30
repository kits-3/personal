package com.booking.entity;

public class BookingEntity {
	private int idBooking;
	private int idUser;
	private int idMovie;
	private int idPrice;
	private String seatPosition;
	public BookingEntity() {}
	public BookingEntity(int idBooking, int idUser, int idMovie, int idPrice, String seatPosition) {
		super();
		this.idBooking = idBooking;
		this.idUser = idUser;
		this.idMovie = idMovie;
		this.idPrice = idPrice;
		this.seatPosition = seatPosition;
	}
	public int getIdBooking() {
		return idBooking;
	}
	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	public int getIdPrice() {
		return idPrice;
	}
	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
	}
	public String getSeatPosition() {
		return seatPosition;
	}
	public void setSeatPosition(String seatPosition) {
		this.seatPosition = seatPosition;
	}
	
}
