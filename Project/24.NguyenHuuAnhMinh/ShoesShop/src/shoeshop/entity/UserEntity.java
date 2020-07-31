package shoeshop.entity;

public class UserEntity {
	private int UserID;
	private String userName;
	private String userLoginID;
	private String phone;
	private String email_address;
	private String password;
	private int Moneyleft;
	private String role;
	
	public UserEntity() {
		super();
	}

	public UserEntity(int userId, String userName, String userLoginID, String phone, String email_address, String password,
			int moneyleft, String role) {
		super();
		this.UserID = userId;
		this.userName = userName;
		this.userLoginID = userLoginID;
		this.phone = phone;
		this.email_address = email_address;
		this.password = password;
		this.Moneyleft = moneyleft;
		this.role = role;
	}

	public int getUserId() {
		return UserID;
	}

	public void setUserId(int userId) {
		this.UserID = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLoginID() {
		return userLoginID;
	}

	public void setUserLoginID(String userLoginID) {
		this.userLoginID = userLoginID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoneyleft() {
		return Moneyleft;
	}

	public void setMoneyleft(int moneyleft) {
		Moneyleft = moneyleft;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
