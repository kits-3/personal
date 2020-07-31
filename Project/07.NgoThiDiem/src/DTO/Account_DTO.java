package DTO;

import java.io.Serializable;

public class Account_DTO implements Serializable {

	//Properties class Account_DTO
		private int accountID;
		private String userName;
		private String email;
		private String passWord;
		private int perMission;
		
	// constructor
public 	 Account_DTO  (int accountID, String userName, String email, String passWord, int perMission   )
   {
	this.accountID = accountID;
	this.userName = userName;
	this.email = email;
	this.passWord = passWord;
	this.perMission = perMission;

   }
//Geter setter

	public Account_DTO() {
		super();
}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
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

	public int getPerMission() {
		return perMission;
	}

	public void setPerMission(int perMission) {
		this.perMission = perMission;
	}
	public int[] array_id_acount  = new int[100];
	public String[] array_username = new String[100];
	public String[] array_email = new String[100];
	public String[] array_password = new String[100];
	public int[] array_permission  = new int[100];
	
}
