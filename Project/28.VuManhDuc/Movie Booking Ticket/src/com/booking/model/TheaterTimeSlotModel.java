package com.booking.model;

import java.sql.Time;

public class TheaterTimeSlotModel {
	private int idTheater;
	private String theaterName;
	private int idTimeSlot;
	private String timeSlot;
	private Time timeStart;
	private Time timeEnd;
	public TheaterTimeSlotModel() {}
	
	

	public TheaterTimeSlotModel(int idTheater, String theaterName, int idTimeSlot, String timeSlot, Time timeStart,
			Time timeEnd) {
		super();
		this.idTheater = idTheater;
		this.theaterName = theaterName;
		this.idTimeSlot = idTimeSlot;
		this.timeSlot = timeSlot;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}



	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public int getIdTheater() {
		return idTheater;
	}

	public void setIdTheater(int idTheater) {
		this.idTheater = idTheater;
	}

	public int getIdTimeSlot() {
		return idTimeSlot;
	}

	public void setIdTimeSlot(int idTimeSlot) {
		this.idTimeSlot = idTimeSlot;
	}



	public Time getTimeStart() {
		return timeStart;
	}



	public void setTimeStart(Time timeStart) {
		this.timeStart = timeStart;
	}



	public Time getTimeEnd() {
		return timeEnd;
	}



	public void setTimeEnd(Time timeEnd) {
		this.timeEnd = timeEnd;
	}
	
}
