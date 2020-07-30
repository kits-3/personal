package kits.studyonline.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
	private int id;
	private String name;
	private String pwd;
	private int role;
	
	public UserEntity() {
		super();
	}
	public UserEntity(int id,String name, String pwd, int role) {
		super();
		this.id=id;
		this.name=name;
		this.pwd=pwd;
		this.role=role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

}
