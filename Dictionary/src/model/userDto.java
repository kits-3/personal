package model;

public class userDto {
	private String userName;
	private String passWord;
	private int roleId;
	
	public userDto(String userName, String passWord, int roleId) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.roleId = roleId;
	}
	public userDto() {
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	

}
