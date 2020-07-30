package home.note.entity;

import java.io.Serializable;

public class clUser implements Serializable{
	static final long serialVersionUID = 42L;
	private String id;
	private String username;
	private String password;
	private String date_reg;
	private String role;
	public clUser(String id, String username, String password, String date_reg, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.date_reg = date_reg;
		this.role = role;
	}
	public clUser() {};
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDate_reg() {
		return date_reg;
	}
	public void setDate_reg(String date_reg) {
		this.date_reg = date_reg;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}

