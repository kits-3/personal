package parkingSystem.entity;

public class user {
	private int id;
	private String fname;
	private String lname;
	private String phone;
	private String pass;
	private String role;
	private String username;
	
	public user() {
		super();
	}

	public user(int id, String fname, String lname, String phone, String pass, String role, String username) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.pass = pass;
		this.role = role;
		this.username = username;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
