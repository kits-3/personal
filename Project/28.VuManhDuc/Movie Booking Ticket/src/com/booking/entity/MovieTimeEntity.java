package com.booking.entity;

import java.sql.Time;

public class MovieTimeEntity {
	private int idMovTime;
	private Time timeStart;
	private Time timeEnd;
	private String nameMovTime;
	public MovieTimeEntity() {}
	public int getIdMovTime() {
		return idMovTime;
	}
	public void setIdMovTime(int idMovTime) {
		this.idMovTime = idMovTime;
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
	public String getNameMovTime() {
		return nameMovTime;
	}
	public void setNameMovTime(String nameMovTime) {
		this.nameMovTime = nameMovTime;
	}
	public MovieTimeEntity(int idMovTime, Time timeStart, Time timeEnd, String nameMovTime) {
		super();
		this.idMovTime = idMovTime;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.nameMovTime = nameMovTime;
	}
	
}
