package Entity;

public class userDto {
	private String userName;
	private String passWord;
	private int roleId;
	private String email;

	public userDto(String userName, String passWord, int roleId, String email) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.roleId = roleId;
		this.email = email;
	}

	public userDto() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
