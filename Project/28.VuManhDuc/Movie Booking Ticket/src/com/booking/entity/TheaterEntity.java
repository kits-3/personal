package com.booking.entity;

public class TheaterEntity {
	private int idTheater;
	private String theaterName;
	private int rowQuant;
	private int colQuant;
	public TheaterEntity() {}
	public TheaterEntity(int idTheater, String theaterName, int rowQuant, int colQuant) {
		super();
		this.idTheater = idTheater;
		this.theaterName = theaterName;
		this.rowQuant = rowQuant;
		this.colQuant = colQuant;
	}
	public int getIdTheater() {
		return idTheater;
	}
	public void setIdTheater(int idTheater) {
		this.idTheater = idTheater;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getRowQuant() {
		return rowQuant;
	}
	public void setRowQuant(int rowQuant) {
		this.rowQuant = rowQuant;
	}
	public int getColQuant() {
		return colQuant;
	}
	public void setColQuant(int colQuant) {
		this.colQuant = colQuant;
	}
	
}
