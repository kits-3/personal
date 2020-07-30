package com.booking.entity;

import java.sql.Time;

public class NotiEntity {
	private String notiDay;
	private Time notiTime;
	private String content;
	public NotiEntity() {}
	public NotiEntity(String notiDay, Time notiTime, String content) {
		super();
		this.notiDay = notiDay;
		this.notiTime = notiTime;
		this.content = content;
	}
	public String getNotiDay() {
		return notiDay;
	}
	public void setNotiDay(String notiDay) {
		this.notiDay = notiDay;
	}
	public Time getNotiTime() {
		return notiTime;
	}
	public void setNotiTime(Time notiTime) {
		this.notiTime = notiTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
