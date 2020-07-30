package dung.dto;

public class User {

	private int id;
	private String user;
	private String password;
	private String role_name;

	public User() {

	}

	public User(int id, String user, String password, String role_name) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.role_name = role_name;
	}

	public User(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String toString() {
		String print = "Id: "+id+"\tUser: "+user+"\tPassword: "+password+"\tRole_name: "+role_name;
		return print;
	}
}
