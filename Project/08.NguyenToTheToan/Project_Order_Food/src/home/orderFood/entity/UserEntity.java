package home.orderFood.entity;





public class UserEntity {
	private int id;
	private String FullNameUser;
	private String userName;
	private String passWordUser;
	private String emailUser;
	private String phoneUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullNameUser() {
		return FullNameUser;
	}
	public void setFullNameUser(String fullNameUser) {
		FullNameUser = fullNameUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWordUser() {
		return passWordUser;
	}
	public void setPassWordUser(String passWordUser) {
		this.passWordUser = passWordUser;
		
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getPhoneUser() {
		return phoneUser;
	}
	public void setPhoneUser(String phoneUser) {
		this.phoneUser = phoneUser;
	}
}
