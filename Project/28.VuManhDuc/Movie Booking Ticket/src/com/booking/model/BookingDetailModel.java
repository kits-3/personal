package com.booking.model;

public class BookingDetailModel {
	private String nameuser;
	private String movieName;
	private String seatPosition;
	private int price;
	private String movieDay;
	private String theaterName;
	private String timeStart;
	private String timeEnd;
	public BookingDetailModel() {}
	public BookingDetailModel(String nameuser, String movieName, String seatPosition, int price, String movieDay,
			String theaterName, String timeStart, String timeEnd) {
		super();
		this.nameuser = nameuser;
		this.movieName = movieName;
		this.seatPosition = seatPosition;
		this.price = price;
		this.movieDay = movieDay;
		this.theaterName = theaterName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	public String getNameuser() {
		return nameuser;
	}
	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getSeatPosition() {
		return seatPosition;
	}
	public void setSeatPosition(String seatPosition) {
		this.seatPosition = seatPosition;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMovieDay() {
		return movieDay;
	}
	public void setMovieDay(String movieDay) {
		this.movieDay = movieDay;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	
	
}
