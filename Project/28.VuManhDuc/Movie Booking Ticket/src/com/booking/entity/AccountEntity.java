package com.booking.entity;

public class AccountEntity {
	private int idUser;
	private String username;
	private String password;
	private String role;
	private String nameOfUser;
	private int age;
	public AccountEntity() {}
	
	public AccountEntity(int idUser, String username, String password, String role, String nameOfUser, int age) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.role = role;
		this.nameOfUser = nameOfUser;
		this.age = age;
	}

	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNameOfUser() {
		return nameOfUser;
	}
	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
